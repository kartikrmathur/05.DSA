# Kotlin Fundamentals

Companion to the Java fundamentals notes in `0001`–`0010`. Kotlin-only theory, kept brief. Add a new `#` section here each time a Java fundamentals note needs a Kotlin counterpart.

# Memory Management

Kotlin on the JVM (Android, backend) uses the exact same memory model as Java — no separate Kotlin memory management exists for this target.

1. Garbage collection is automatic, handled by the JVM GC — same as Java. No manual allocation/deallocation in Kotlin either.
2. Variables: stack memory. Objects: heap memory. Same split as Java.
3. Primitives (`Int`, `Long`, `Boolean`, etc.) compile to JVM primitives (stack) when possible, but auto-box into wrapper objects (heap) when used as nullable (`Int?`) or in generics (`List<Int>`) — same boxing behavior as Java's `Integer`, just hidden since Kotlin doesn't make you write the wrapper type.
4. `data class` is a normal heap-allocated object — the generated `equals()`/`hashCode()`/`toString()` don't change memory placement.
5. Kotlin/Native (iOS/desktop targets, not JVM) has its own ARC-style memory manager — not relevant for Android/backend Kotlin, skip unless asked about multiplatform specifically.
