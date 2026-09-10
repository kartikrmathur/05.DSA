# Heaps / Priority Queue — Quick Recall

Status: gap-filler starter sheet (see `GAPS_AND_ROADMAP.md`). Ties directly into your existing Sorting (0038-0044) and Hashing (0107-0117) work — heaps are how you do "top K" efficiently instead of sorting everything.

## Java: `PriorityQueue` is a min-heap by default

```java
PriorityQueue<Integer> minHeap = new PriorityQueue<>();              // min-heap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
minHeap.offer(5);
int smallest = minHeap.poll();   // removes and returns
int peek = minHeap.peek();       // without removing
```

For custom objects, pass a comparator:
```java
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min by first element
```

## Kotlin: same class, available straight from the Java standard library

```kotlin
val minHeap = PriorityQueue<Int>()
val maxHeap = PriorityQueue<Int>(compareByDescending { it })
minHeap.offer(5)
val smallest = minHeap.poll()
```
Kotlin doesn't have its own heap type — you use Java's `PriorityQueue` directly, just with Kotlin's lambda/comparator syntax (`compareBy` / `compareByDescending` instead of `Comparator.comparingInt`).

## Kth Largest Element — the canonical heap problem
Maintain a **min-heap of size K**. For each new element: push it, and if size > K, pop the smallest. At the end, the top of the heap is the Kth largest.

**Java**
```java
int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int n : nums) {
        minHeap.offer(n);
        if (minHeap.size() > k) minHeap.poll();
    }
    return minHeap.peek();
}
```
This is O(n log k), much better than sorting (O(n log n)) when k is small — say this out loud in the interview, it's the point of the question.

## Median of a running stream — two heaps
Keep a max-heap for the lower half and a min-heap for the upper half, balanced so their sizes differ by at most 1. Median is either the top of the larger heap, or the average of both tops when sizes are equal. This combines directly with your existing 0032 (Median of a Matrix) intuition — same "split around the middle" idea, applied to a stream instead of a static structure.

## Merge K sorted lists — heap of (value, list pointer)
Push the head of each list into a min-heap keyed by value. Pop the smallest, append to result, push its `next` if it exists. This is the natural extension of your existing "merge two sorted lists" pattern (see `LinkedList.md`) to K lists — recognize that connection rather than re-deriving from scratch.

## Heap Sort (since it's also a roadmap gap)
Build a max-heap from the array (`O(n)`), then repeatedly swap the root with the last unsorted element and sift down (`O(log n)` each, `n` times) → `O(n log n)` overall, in-place, **not stable**. Worth implementing by hand once since "implement heap sort without a library heap" is a real ask.

## Practice queue
1. Kth largest / smallest element
2. Top K frequent elements (combine with your existing HashMap counting from 0109)
3. Median of a data stream
4. Merge K sorted lists
5. Heap sort, implemented from scratch (array-based, no `PriorityQueue`)
