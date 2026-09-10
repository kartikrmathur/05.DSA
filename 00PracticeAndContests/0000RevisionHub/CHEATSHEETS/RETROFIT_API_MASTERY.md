# Retrofit + API in Android (Kotlin) — Interview Mastery Guide

> Built after the Swiggy machine-coding feedback: **"strengthen Retrofit & API."**
> This is the exact networking depth a senior Android round (Swiggy / ixigo tier) probes.
> Read top-to-bottom once, then use the **Interview Q&A** + **Checklist** the night before.

---

## 0. The one-paragraph mental model

An Android app never talks HTTP directly. The stack is:

```
Your Repository  ->  Retrofit (interface -> HTTP)  ->  OkHttp (the actual HTTP client:
                                                        sockets, timeouts, interceptors, cache)
                                                     ->  Converter (JSON <-> Kotlin objects)
```

- **Retrofit** = turns a Kotlin `interface` into HTTP calls. It does NOT do networking itself.
- **OkHttp** = the engine that actually sends bytes over the wire (Retrofit delegates to it).
- **Converter** (Moshi / Gson / kotlinx.serialization) = JSON string <-> your `data class`.
- If you can explain *"Retrofit is a type-safe wrapper over OkHttp; OkHttp does the real work"* — you already sound senior.

---

## 1. Dependencies (know what each line is)

```kotlin
// build.gradle (app)
implementation("com.squareup.retrofit2:retrofit:2.11.0")          // Retrofit core
implementation("com.squareup.retrofit2:converter-moshi:2.11.0")   // JSON converter (or gson)
implementation("com.squareup.okhttp3:okhttp:4.12.0")              // HTTP engine
implementation("com.squareup.okhttp3:logging-interceptor:4.12.0") // debug logging
implementation("com.squareup.moshi:moshi-kotlin:1.15.1")          // Moshi + Kotlin support
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
```

Retrofit ≥ 2.6 supports **`suspend`** functions natively — no more `Call<T>` + callbacks needed.

---

## 2. Defining the API interface (the annotations that matter)

```kotlin
interface PokemonApi {

    // GET with a query param -> /pokemon?limit=20&offset=0
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListDto

    // GET with a path param -> /pokemon/pikachu
    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String
    ): PokemonDetailDto

    // POST with a JSON body
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    // Custom header per-call
    @GET("profile")
    suspend fun getProfile(@Header("Authorization") token: String): ProfileDto

    // Full Response wrapper when you need status code / headers
    @GET("pokemon/{name}")
    suspend fun getPokemonRaw(@Path("name") name: String): Response<PokemonDetailDto>
}
```

**Annotation cheat table**

| Annotation | Use | Example |
|---|---|---|
| `@GET`/`@POST`/`@PUT`/`@DELETE`/`@PATCH` | HTTP verb + relative path | `@GET("pokemon")` |
| `@Path` | substitute `{}` in the URL | `@Path("name") name` |
| `@Query` | add `?key=value` | `@Query("limit") limit` |
| `@QueryMap` | dynamic map of query params | `@QueryMap m: Map<String,String>` |
| `@Body` | serialize object -> request body | `@Body req: LoginRequest` |
| `@Header` / `@HeaderMap` | per-call header(s) | `@Header("Authorization")` |
| `@Headers("Cache-Control: no-cache")` | static header(s) | above a method |
| `@Field` + `@FormUrlEncoded` | form POST | login forms |
| `@Part` + `@Multipart` | file upload | image upload |

**Return-type choices**
- `suspend fun x(): Dto` — cleanest. Throws on non-2xx / IO error.
- `suspend fun x(): Response<Dto>` — gives you `.code()`, `.headers()`, `.isSuccessful`, `.errorBody()`. Use when you must branch on status codes (401, 404).
- `Call<Dto>` — old callback style. Avoid in new code (mention you know it exists).

---

## 3. Building Retrofit + OkHttp (the part they love to probe)

```kotlin
val logging = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
}

val authInterceptor = Interceptor { chain ->
    val request = chain.request().newBuilder()
        .addHeader("Authorization", "Bearer ${tokenProvider.token()}")
        .build()
    chain.proceed(request)
}

val okHttp = OkHttpClient.Builder()
    .connectTimeout(15, TimeUnit.SECONDS)   // time to establish TCP/TLS
    .readTimeout(20, TimeUnit.SECONDS)      // time between bytes while reading
    .writeTimeout(20, TimeUnit.SECONDS)     // time between bytes while writing
    .addInterceptor(authInterceptor)        // application interceptor (runs once)
    .addInterceptor(logging)                // order matters: logging LAST to log final request
    .retryOnConnectionFailure(true)
    .build()

val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

val retrofit = Retrofit.Builder()
    .baseUrl("https://pokeapi.co/api/v2/")  // MUST end with "/"
    .client(okHttp)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

val api: PokemonApi = retrofit.create(PokemonApi::class.java)
```

**Gotchas interviewers check:**
- `baseUrl` **must end with `/`** or Retrofit throws.
- A `@GET("/pokemon")` with a **leading slash** resets to the host root and drops `/api/v2/`. Use `@GET("pokemon")` (no leading slash).
- **Interceptor order**: `addInterceptor` (application) runs once per call; `addNetworkInterceptor` runs per network hop (sees redirects/retries). Put logging last so it logs the fully-built request (with auth header).
- Timeouts: know the three (connect / read / write). Default is 10s each. "No timeout set" → app can hang → **ANR** (ties to the ixigo feedback).

---

## 4. Serialization — DTOs done right

```kotlin
// Moshi
@JsonClass(generateAdapter = true)
data class PokemonListDto(
    val count: Int,
    val next: String?,                     // nullable! API can return null
    @Json(name = "results") val results: List<PokemonEntryDto>
)

@JsonClass(generateAdapter = true)
data class PokemonEntryDto(
    val name: String,
    val url: String
)
```

- Gson equivalent: `@SerializedName("results")`.
- **Golden rules:**
  - Mark every field the server *might* omit or null as **nullable (`?`)**. A non-null field that arrives null = crash. (Common machine-coding failure.)
  - Keep **DTOs separate from domain models**. DTO = wire shape; domain = what your UI uses. Map DTO -> domain in the repository.
  - Prefer **kotlinx.serialization** or **Moshi codegen** over Gson for Kotlin (Gson ignores default values & non-null types via reflection — can inject nulls into non-null fields).

```kotlin
// DTO -> domain mapping (keep the app decoupled from the API)
fun PokemonEntryDto.toDomain() = Pokemon(
    name = name.replaceFirstChar { it.uppercase() },
    id = url.trimEnd('/').substringAfterLast('/').toInt()
)
```

---

## 5. Coroutines integration (threading — do NOT get this wrong)

```kotlin
class PokemonRepository(
    private val api: PokemonApi,
    private val io: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun pokemonList(limit: Int, offset: Int): List<Pokemon> =
        withContext(io) {                       // move off main thread
            api.getPokemonList(limit, offset).results.map { it.toDomain() }
        }
}
```

- Retrofit's `suspend` calls are **already dispatched on OkHttp's background threads**, so an explicit `withContext(IO)` isn't strictly required *for the call itself* — but wrapping heavy mapping/parsing in `withContext(io)` is good practice and shows intent.
- **Never** call a suspend API function from the main thread and then do blocking work.
- In a ViewModel use `viewModelScope.launch { ... }` — it auto-cancels on `onCleared()`, preventing leaks (ties to ixigo's "memory management" note).

---

## 6. Error handling — the #1 thing that separates mid from senior

Wrap every network call in a **sealed result** so the UI never sees a raw exception.

```kotlin
sealed interface ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>
    data class Error(val code: Int?, val message: String) : ApiResult<Nothing>
    data object NetworkError : ApiResult<Nothing>   // no internet / timeout
}

suspend fun <T> safeCall(block: suspend () -> T): ApiResult<T> = try {
    ApiResult.Success(block())
} catch (e: HttpException) {                 // non-2xx (400/401/404/500...)
    ApiResult.Error(e.code(), e.message())
} catch (e: IOException) {                   // no network, timeout, socket
    ApiResult.NetworkError
} catch (e: Exception) {                     // parsing / unexpected
    ApiResult.Error(null, e.message ?: "Unknown error")
}
```

Usage:
```kotlin
val result = safeCall { api.getPokemonDetail(name) }
when (result) {
    is ApiResult.Success   -> _state.value = UiState.Data(result.data.toDomain())
    is ApiResult.NetworkError -> _state.value = UiState.Error("Check your connection")
    is ApiResult.Error     -> _state.value = UiState.Error("Server: ${result.code}")
}
```

**Know these three exception types cold:**
- `retrofit2.HttpException` — the call reached the server but got a non-2xx code.
- `java.io.IOException` (incl. `SocketTimeoutException`, `UnknownHostException`) — never reached / timed out.
- Converter/parse exceptions — malformed JSON, null-into-non-null.

For `Response<T>` style, branch on `response.isSuccessful` / `response.code()` and read `response.errorBody()?.string()` for the server error payload.

---

## 7. Repository pattern + single source of truth (Room cache)

Senior interviews want the **NetworkBoundResource** idea: UI reads from DB; network refreshes DB.

```kotlin
fun pokemonStream(name: String): Flow<Pokemon> = flow {
    val cached = dao.get(name)               // 1. emit cache first (instant UI)
    if (cached != null) emit(cached.toDomain())
    val fresh = api.getPokemonDetail(name)   // 2. hit network
    dao.upsert(fresh.toEntity())             // 3. save
    emit(fresh.toDomain())                   // 4. emit fresh
}.flowOn(Dispatchers.IO)
    .catch { /* emit cached / error */ }
```

Talking points: **offline-first**, **DB as single source of truth**, **Flow** so UI auto-updates.

---

## 8. Pagination (the Pokémon list is the classic case)

- Manual: track `offset`, load next page when user hits the end of `LazyColumn`/`RecyclerView`, append to list, guard against duplicate loads with an `isLoading` flag.
- Production: **Paging 3** (`PagingSource` + `Pager` + `collectAsLazyPagingItems()`), handles page keys, retry, loading/error footers.

```kotlin
class PokemonPagingSource(private val api: PokemonApi) : PagingSource<Int, Pokemon>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> = try {
        val offset = params.key ?: 0
        val resp = api.getPokemonList(limit = params.loadSize, offset = offset)
        LoadResult.Page(
            data = resp.results.map { it.toDomain() },
            prevKey = if (offset == 0) null else offset - params.loadSize,
            nextKey = if (resp.next == null) null else offset + params.loadSize
        )
    } catch (e: Exception) { LoadResult.Error(e) }
    override fun getRefreshKey(state: PagingState<Int, Pokemon>) = state.anchorPosition
}
```

---

## 9. Retry / batching / timeouts (directly from ixigo's feedback)

- **Timeouts** — always set connect/read/write; unset timeouts cause hangs → ANRs.
- **Retry with backoff** — use an OkHttp interceptor for idempotent GETs:

```kotlin
class RetryInterceptor(private val maxRetries: Int = 3) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var attempt = 0; var response: Response? = null; var error: IOException? = null
        while (attempt < maxRetries) {
            try {
                response?.close()
                response = chain.proceed(chain.request())
                if (response.isSuccessful) return response
            } catch (e: IOException) { error = e }
            attempt++
            Thread.sleep((1000L * (1 shl attempt)))   // exponential backoff: 2s,4s,8s
        }
        return response ?: throw (error ?: IOException("Retry failed"))
    }
}
```

- **Batching** — coalesce multiple detail calls with `coroutineScope { list.map { async { api.getDetail(it) } }.awaitAll() }` (parallel, structured, cancels together). Don't fire 100 serial calls.

---

## 10. Testing the network layer (bonus points)

```kotlin
// MockWebServer — a fake server you control in unit tests
val server = MockWebServer()
server.enqueue(MockResponse().setBody(pokemonJson).setResponseCode(200))
server.start()
val api = Retrofit.Builder().baseUrl(server.url("/"))
    .addConverterFactory(MoshiConverterFactory.create()).build()
    .create(PokemonApi::class.java)
// ... call api, assert result, assert server.takeRequest().path
```

Mention: `MockWebServer` for the Retrofit layer, fake `Repository` for the ViewModel, `Turbine` for `Flow` tests.

---

## 11. Common failure points (self-check before any round)

- [ ] `baseUrl` ends with `/`, paths have **no** leading `/`.
- [ ] Every possibly-missing JSON field is **nullable**.
- [ ] All 3 timeouts set on OkHttp.
- [ ] Calls wrapped in `safeCall` -> sealed result; UI shows loading/data/error/empty.
- [ ] Work off the main thread; scope tied to lifecycle (`viewModelScope`).
- [ ] DTO ≠ domain model; mapping in repository.
- [ ] Single OkHttp/Retrofit instance (expensive) — inject as singleton (Hilt), don't rebuild per call.
- [ ] Logging interceptor OFF in release.

---

## 12. Interview Q&A — likely questions + crisp answers

**Q: Is Retrofit the thing that makes the network call?**
No. Retrofit turns my interface into requests and delegates the actual HTTP to **OkHttp**. OkHttp manages sockets, the connection pool, timeouts, interceptors, and caching.

**Q: Application vs network interceptor?**
Application interceptors run **once** per call (great for auth headers, logging). Network interceptors run for **every** network hop, so they see redirects and retries and the actual wire request/response.

**Q: How do you handle errors?**
Catch `HttpException` (non-2xx), `IOException` (no network/timeout), and parse errors separately, map them into a sealed `ApiResult`, and render loading/data/error/empty states. Never leak a raw exception to the UI.

**Q: How do you avoid blocking the UI thread / ANR?**
Retrofit `suspend` calls run on background threads; I keep heavy mapping in `withContext(Dispatchers.IO)`, set OkHttp timeouts so calls can't hang, and scope coroutines to lifecycle.

**Q: Gson vs Moshi vs kotlinx.serialization?**
Gson uses reflection and can violate Kotlin null-safety (inject null into non-null). Moshi (with codegen) and kotlinx.serialization are Kotlin-first, safer, and faster. I prefer Moshi/kotlinx for new code.

**Q: How do you cache / support offline?**
OkHttp disk cache for HTTP-level caching, or app-level single-source-of-truth with Room: UI observes the DB via `Flow`; network refreshes the DB. Offline-first.

**Q: How do you cancel an in-flight request?**
Cancel the coroutine (its `Job`); structured concurrency propagates cancellation and OkHttp cancels the call. `viewModelScope` cancels automatically on `onCleared()`.

**Q: 401 handling?**
An **Authenticator** (OkHttp) to refresh the token and retry once, or an interceptor that catches 401, refreshes, and replays the request.

---

## 13. The Pokémon-app reference architecture (what to build, cleanly)

```
data/
  remote/  PokemonApi, dtos, RetrofitProvider
  local/   PokemonDao, PokemonEntity (Room)  [optional cache]
  PokemonRepository (safeCall, DTO->domain, Flow)
domain/
  model/   Pokemon (clean model)
ui/
  list/    ListViewModel (viewModelScope, UiState sealed), LazyColumn + paging
  detail/  DetailViewModel, detail screen
di/        Hilt modules providing OkHttp, Retrofit, Api, Repository as singletons
```

UiState pattern for every screen:
```kotlin
sealed interface UiState {
    data object Loading : UiState
    data class Data(val items: List<Pokemon>) : UiState
    data class Error(val msg: String) : UiState
    data object Empty : UiState
}
```

**If you rebuild the Pokémon app to demonstrate the fix:** lead with the `RetrofitProvider` (timeouts + interceptors + Moshi), the `safeCall` wrapper, nullable DTOs with DTO→domain mapping, and `viewModelScope` + `UiState`. Say out loud *why* at each step — that narration is what they graded you on.

---

## 14. 30-minute pre-round warm-up
1. Rebuild `RetrofitProvider` from memory (base URL `/`, 3 timeouts, logging + auth interceptor, Moshi).
2. Write the `safeCall` sealed-result wrapper from memory.
3. Write one `suspend` GET with `@Path` and one with `@Query`.
4. Say the 3 exception types and what each means.
5. Explain interceptor order + application-vs-network in one breath.

Nail these five and the "strengthen Retrofit & API" gap is closed.
