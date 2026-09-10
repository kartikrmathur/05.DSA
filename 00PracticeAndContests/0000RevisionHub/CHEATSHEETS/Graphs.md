# Graphs — Quick Recall

Status: gap-filler starter sheet (see `GAPS_AND_ROADMAP.md`).

## Representation — adjacency list (the one you'll use 95% of the time)

**Java**
```java
Map<Integer, List<Integer>> graph = new HashMap<>();
graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // if undirected
```

**Kotlin**
```kotlin
val graph = mutableMapOf<Int, MutableList<Int>>()
graph.getOrPut(u) { mutableListOf() }.add(v)
graph.getOrPut(v) { mutableListOf() }.add(u) // if undirected
```
`getOrPut` is Kotlin's direct equivalent of Java's `computeIfAbsent` — same idea, recognize the mapping.

## BFS — shortest path in unweighted graph, uses a Queue (same data structure as your 0071)

**Java**
```java
void bfs(int start, Map<Integer, List<Integer>> graph) {
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> q = new ArrayDeque<>();
    q.add(start);
    visited.add(start);
    while (!q.isEmpty()) {
        int node = q.poll();
        for (int neighbor : graph.getOrDefault(node, List.of())) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor);
                q.add(neighbor);
            }
        }
    }
}
```

## DFS — recursive, or iterative with an explicit stack (same Stack you know from 0057)

**Java (recursive)**
```java
void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
    if (visited.contains(node)) return;
    visited.add(node);
    for (int neighbor : graph.getOrDefault(node, List.of())) {
        dfs(neighbor, graph, visited);
    }
}
```

**Kotlin (recursive)**
```kotlin
fun dfs(node: Int, graph: Map<Int, List<Int>>, visited: MutableSet<Int>) {
    if (node in visited) return
    visited.add(node)
    for (neighbor in graph[node].orEmpty()) {
        dfs(neighbor, graph, visited)
    }
}
```
`node in visited` is Kotlin's idiomatic `contains` check — cleaner than `visited.contains(node)`, same thing.

## Topological Sort (Kahn's algorithm — BFS based, uses in-degrees)
1. Compute in-degree of every node.
2. Push all nodes with in-degree 0 into a queue.
3. Pop a node, add to result, decrement in-degree of its neighbors; if a neighbor's in-degree hits 0, push it.
4. If result size < total nodes at the end → there's a cycle (no valid topological order).

This is the standard "course schedule" / build-order question template.

## Union-Find (Disjoint Set) — for cycle detection in undirected graphs, Kruskal's MST

**Java**
```java
int[] parent;
int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]); // path compression
    return parent[x];
}
void union(int a, int b) {
    int ra = find(a), rb = find(b);
    if (ra != rb) parent[ra] = rb;
}
```
Initialize `parent[i] = i` for all nodes. If `find(a) == find(b)` before union, adding edge (a,b) creates a cycle — that's the whole trick for "detect cycle in undirected graph."

## Dijkstra's (shortest path, weighted, non-negative edges) — heap-driven, connects directly to `Heaps.md`

**Java**
```java
int[] dijkstra(int src, int n, Map<Integer, List<int[]>> graph) { // graph: node -> [neighbor, weight]
    int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // [node, dist]
    pq.offer(new int[]{src, 0});
    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int node = curr[0], d = curr[1];
        if (d > dist[node]) continue; // stale entry
        for (int[] edge : graph.getOrDefault(node, List.of())) {
            int next = edge[0], weight = edge[1];
            if (dist[node] + weight < dist[next]) {
                dist[next] = dist[node] + weight;
                pq.offer(new int[]{next, dist[next]});
            }
        }
    }
    return dist;
}
```

## Practice queue
1. BFS + DFS on adjacency list (both directions: directed and undirected)
2. Number of connected components / number of islands (grid BFS/DFS — connects to your existing Matrix work in 0032-0036)
3. Topological sort (course schedule problem)
4. Cycle detection (undirected via Union-Find, directed via DFS color-marking)
5. Dijkstra's shortest path
6. Number of provinces / friend circles (Union-Find)
