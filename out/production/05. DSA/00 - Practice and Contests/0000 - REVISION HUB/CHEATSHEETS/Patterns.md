# Interview Patterns — Quick Recall

Covers the named patterns that don't have a dedicated topic anywhere in `05. DSA` yet: Sliding Window, Two Pointer, Backtracking, Greedy, Trie. See `GAPS_AND_ROADMAP.md` for priority order.

## Two Pointer
Use when the array/string is sorted (or can be) and you're looking for a pair/triplet matching a condition.

**Java — Two Sum on sorted array**
```java
int[] twoSumSorted(int[] arr, int target) {
    int lo = 0, hi = arr.length - 1;
    while (lo < hi) {
        int sum = arr[lo] + arr[hi];
        if (sum == target) return new int[]{lo, hi};
        if (sum < target) lo++; else hi--;
    }
    return new int[]{-1, -1};
}
```
**Kotlin**
```kotlin
fun twoSumSorted(arr: IntArray, target: Int): Pair<Int, Int> {
    var lo = 0; var hi = arr.size - 1
    while (lo < hi) {
        val sum = arr[lo] + arr[hi]
        when {
            sum == target -> return lo to hi
            sum < target -> lo++
            else -> hi--
        }
    }
    return -1 to -1
}
```
`lo to hi` builds a `Pair` — idiomatic Kotlin for returning two values without a custom class.

## Sliding Window
Use for "longest/shortest subarray or substring satisfying X" — avoids the O(n²) brute force of checking every window.

**Java — longest substring without repeating characters**
```java
int lengthOfLongestSubstring(String s) {
    Set<Character> seen = new HashSet<>();
    int left = 0, maxLen = 0;
    for (int right = 0; right < s.length(); right++) {
        while (seen.contains(s.charAt(right))) {
            seen.remove(s.charAt(left));
            left++;
        }
        seen.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```
Template: expand `right` every iteration; shrink `left` while the window is invalid; track the best window size. Same shape works for "max subarray sum size k" (fixed window — no shrink condition, just slide) and "minimum window substring" (variable window, shrink while still valid to find the *minimum*).

## Backtracking
Use for "generate all..." (subsets, permutations, combinations) or constraint satisfaction (N-Queens, Sudoku). Template: choose → explore → un-choose (backtrack).

**Java — subsets**
```java
void backtrack(int[] nums, int start, List<Integer> curr, List<List<Integer>> result) {
    result.add(new ArrayList<>(curr));
    for (int i = start; i < nums.length; i++) {
        curr.add(nums[i]);              // choose
        backtrack(nums, i + 1, curr, result); // explore
        curr.remove(curr.size() - 1);   // un-choose
    }
}
```
**Kotlin**
```kotlin
fun backtrack(nums: IntArray, start: Int, curr: MutableList<Int>, result: MutableList<List<Int>>) {
    result.add(curr.toList()) // snapshot copy — important, don't add the mutable reference
    for (i in start until nums.size) {
        curr.add(nums[i])
        backtrack(nums, i + 1, curr, result)
        curr.removeAt(curr.size - 1)
    }
}
```
The #1 bug in both languages: forgetting to copy `curr` before adding to `result` (Java: `new ArrayList<>(curr)`, Kotlin: `curr.toList()`) — without the copy, every entry in `result` ends up pointing at the same mutated list.

For **permutations**, swap the "choose from remaining" loop for a used-boolean array or by removing/restoring from the candidate list. For **N-Queens/Sudoku**, the structure is the same — choose a cell, check `isValid()`, recurse, undo if it fails.

## Greedy
Use when a locally optimal choice at each step provably leads to a globally optimal solution — usually paired with sorting first.

- **Interval scheduling (max non-overlapping intervals):** sort by end time, greedily pick the next interval that starts after the last picked one ends.
- **Jump Game:** track the farthest reachable index; if current index exceeds it, fail.
- **Gas Station:** if total gas >= total cost, a valid start exists; track running tank, reset start point when it goes negative.

The hard part of greedy isn't the code, it's proving greedy is even valid for the problem — in an interview, say why the greedy choice is safe before coding it.

## Trie (prefix tree)
Use for autocomplete, prefix search, word search II.

**Java**
```java
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}
class Trie {
    TrieNode root = new TrieNode();
    void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isEnd = true;
    }
    boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return false;
        }
        return node.isEnd;
    }
}
```
**Kotlin**
```kotlin
class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var isEnd = false
}
class Trie {
    private val root = TrieNode()
    fun insert(word: String) {
        var node = root
        for (c in word) {
            node = node.children.getOrPut(c) { TrieNode() }
        }
        node.isEnd = true
    }
    fun search(word: String): Boolean {
        var node = root
        for (c in word) {
            node = node.children[c] ?: return false
        }
        return node.isEnd
    }
}
```

## Practice queue
1. Sliding window: max sum subarray of size K (fixed), then longest substring without repeat (variable)
2. Two pointer: two sum sorted, 3Sum, container with most water
3. Backtracking: subsets, permutations, combination sum, N-Queens
4. Greedy: jump game, merge intervals, gas station
5. Trie: implement Trie, word search II
