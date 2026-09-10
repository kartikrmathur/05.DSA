# Pattern Theory — How to Choose the Algorithm

The companion to `Patterns.md`. That file has the **code**; this one has the **thinking** — how to recognise which pattern a problem wants before you write a line. This is the layer that separates "I know DSA" from "I solve unseen problems under pressure."

---

## 1. THE MASTER FRAMEWORK — constraints tell you the algorithm

Before anything else, read the constraints. The input size fixes your allowed complexity, and the complexity fixes your candidate algorithms. This single habit answers most "where do I even start" moments.

| n (input size) | Allowed complexity | What that implies |
|---|---|---|
| n ≤ 10–12 | O(n!) / O(2ⁿ) | Permutations, subsets → **backtracking**, brute force |
| n ≤ 20–25 | O(2ⁿ) | Subset enumeration, bitmask DP |
| n ≤ 100–500 | O(n³) | Floyd-Warshall, interval DP, triple loops |
| n ≤ 2,000–5,000 | O(n²) | 2D DP, nested loops, all-pairs comparison |
| n ≤ 10⁵–10⁶ | O(n log n) | **Sorting**, heap, binary search, divide & conquer |
| n ≤ 10⁶–10⁷ | O(n) | **One pass**: two pointers, sliding window, prefix sum, hashing |
| n ≥ 10⁸ or huge/无 limit | O(log n) / O(1) | Binary search on answer, math/formula, bit tricks |

**How to use it live:** "n is 10⁵, so O(n²) is out — I need n log n or better. That points me at sorting, a heap, binary search, or a single pass with a hash map." Say this out loud in the interview; it demonstrates senior thinking even before you solve it.

**Second lever — what does the answer look like?**
- Return a **count/max/min number** → greedy, DP, or a single pass
- Return **all combinations** → backtracking (output size dominates complexity)
- Return **yes/no feasibility** → binary search on answer, union-find, graph reachability
- Return **an ordering** → topological sort, custom comparator sort

---

## 2. RECOGNITION TABLE — problem phrasing → pattern

Memorise the left column. In interviews, patterns announce themselves in the wording.

| The problem says… | Reach for |
|---|---|
| "sorted array" + find pair/triplet | Two pointers (opposite ends) |
| "contiguous subarray/substring" + longest/shortest/max | Sliding window |
| "subarray sum equals K" (any subarray, not contiguous window) | Prefix sum + HashMap |
| "top K" / "K largest" / "K closest" | Heap (size K) or quickselect |
| "next greater / next smaller / previous greater" | Monotonic stack |
| "how many ways" / "min cost to reach" / "can I make X" | DP |
| "all permutations / subsets / combinations / valid boards" | Backtracking |
| "minimum steps in an unweighted grid or graph" | BFS |
| "connected components" / "is A connected to B" | DFS or Union-Find |
| "prerequisites" / "build order" / "cycle in directed graph" | Topological sort (Kahn's) |
| "shortest path with weights" | Dijkstra |
| "find X in sorted / rotated / bounded numeric range" | Binary search |
| "minimise the maximum" or "maximise the minimum" | **Binary search on the answer** |
| "detect cycle / find middle / kth from end" in a list | Fast–slow pointers |
| "duplicate detection", "frequency", "seen before" | HashMap / HashSet |
| "intervals", "meeting rooms", "merge overlapping" | Sort by start, then greedy sweep |
| "in-place with O(1) extra space" on an array | Two pointers / cyclic sort / index-as-hash |
| "stream of data, need median/top" | Two heaps / heap |

---

## 3. PATTERN THEORY — why each one works

### Two Pointers
**Core idea:** maintain two indices whose movement is *monotonic* — they only ever move one direction, so the total work is O(n) instead of O(n²).
**Why it's correct (the invariant):** on a sorted array with `lo`/`hi`, if `arr[lo]+arr[hi] < target`, then **every** pair using `lo` with a smaller partner is also too small — so discarding `lo` loses no valid answer. That elimination argument is what makes it safe to skip work.
**Three variants:**
1. *Opposite ends* — sorted arrays, pair sums, palindromes, container-with-most-water.
2. *Fast–slow* — linked list cycle (Floyd's), middle node, kth-from-end. Fast moves 2×, slow 1×.
3. *Same direction (read/write)* — in-place removal/dedup: `write` lags `read` and only advances on keepers.
**When NOT to use:** unsorted data where sorting destroys required index order (then use a HashMap instead).
**Trap:** forgetting to skip duplicates in 3Sum → duplicate triplets in output.

### Sliding Window
**Core idea:** a contiguous window whose two edges only move right. Each element enters once and leaves once → O(n).
**The invariant is everything:** decide "what makes this window valid," then:
- *Fixed size k* → slide: add right, remove left, no shrink loop.
- *Variable, "longest valid"* → expand right always; `while (invalid) shrink left`; record max **after** the while.
- *Variable, "shortest valid"* → expand right; `while (valid) { record min; shrink left; }` — record **inside** the loop.
Getting max-vs-min recording position right is the #1 sliding-window bug.
**Requires:** contiguity, and a validity condition that's monotonic (adding elements can only push the window one way).
**Trap:** using it on problems that allow non-contiguous picks — that's DP or prefix sum territory.

### Prefix Sum
**Core idea:** precompute cumulative totals so any range sum is O(1): `sum(i..j) = pre[j+1] - pre[i]`.
**The HashMap upgrade:** "count subarrays summing to K" — store how many times each prefix has been seen; at index j, the number of valid subarrays ending at j is `count[pre[j] - K]`. This turns O(n²) into O(n) and works with negative numbers, where sliding window fails.
**When to prefer over sliding window:** negatives present, or subarray needn't satisfy a monotonic window condition.

### Binary Search (two distinct kinds)
**Kind 1 — search a sorted array.** Standard. Use `lo + (hi-lo)/2` to avoid overflow.
**Kind 2 — binary search on the answer.** The one most people miss. Applies when:
- The answer lies in a numeric range, AND
- There's a **monotonic predicate**: if `x` works, everything above (or below) `x` also works.
You then binary-search the *answer space*, using a helper `feasible(x)` to test each candidate.
**Recognition:** "minimise the maximum load", "smallest divisor such that sum ≤ threshold", Koko eating bananas, ship packages in D days, aggressive cows. Your `0024`–`0027` files are all this pattern.
**Template thinking:** define `feasible(x)` first, prove it's monotonic, then it's a mechanical search.
**Trap:** infinite loops from wrong `lo = mid` vs `lo = mid + 1` — pick the boundary convention and use it every time.

### Hashing / Counting
**Core idea:** trade memory for time — O(1) lookup replaces an inner loop.
**Uses:** seen-before checks, frequency counts (`int[26]` for lowercase letters is faster than a HashMap), grouping (anagrams keyed by sorted string or count signature), complement lookup (Two Sum).
**Theory note:** HashMap gives *average* O(1), not worst case — collisions degrade it; Java 8+ converts long buckets to red-black trees, so worst case is O(log n). Interviewers love this follow-up.

### Monotonic Stack
**Core idea:** keep the stack sorted (increasing or decreasing). When a new element violates the order, pop — and each pop *resolves* an answer.
**Why O(n):** every element is pushed once and popped once, regardless of how many pops happen in one iteration.
**Recognition:** next greater/smaller element, daily temperatures, stock span, largest rectangle in histogram, trapping rain water.
**Choosing direction:** want the *next greater* → maintain a **decreasing** stack (pop while `stack.top < current`; the current element is the answer for everything popped).

### Linked List Techniques
**Dummy head:** allocate a fake node before the head whenever the head itself might change (delete-nth, merge, partition). Eliminates every null/special-case branch.
**Fast–slow:** cycle detection (they meet inside the cycle), middle node, kth from end.
**Reversal:** three pointers `prev/curr/next` — memorise until it's muscle memory; it's the most common warm-up question in the world.
**Trap:** losing the rest of the list — always save `next` before rewiring.

### Trees
**Traversal choice matters:**
- *Inorder* on a BST yields **sorted** order → use for validate-BST, kth-smallest.
- *Preorder* → serialise/copy a tree (root first).
- *Postorder* → any problem where a node's answer depends on children's answers: height, diameter, "balanced?", subtree sums, LCA. **Most tree interview problems are postorder in disguise.**
- *BFS/level-order* → level-by-level output, minimum depth, right-side view, shortest path in unweighted structures.
**The recursive contract:** decide what one call *returns to its parent*, and what it *updates globally*. Diameter is the classic: return height to the parent, update a global max inside. Confusing those two is the most common tree bug.
**BST property:** left < root < right lets you prune half the tree — validate-BST needs min/max bounds passed down, not just a parent comparison.

### Graphs
**Representation:** adjacency list (`Map<Integer,List<Integer>>` or `List<List<Integer>>`) for sparse graphs — which is nearly always in interviews.
**BFS vs DFS:** BFS gives **shortest path in unweighted** graphs (level = distance); DFS is for connectivity, cycle detection, topological order, and anything recursive/backtracking-flavoured.
**Grids are graphs.** Number of Islands, Rotting Oranges, flood fill — each cell is a node, neighbours are the 4 directions. Multi-source BFS (push *all* rotten oranges before starting) is the trick for "spread simultaneously" problems.
**Topological sort (Kahn's):** repeatedly remove nodes with in-degree 0. If you can't remove everything, there's a cycle. Recognition: prerequisites, build order, course schedule.
**Union-Find:** near-O(1) "are these connected / merge these groups" with path compression + union by rank. Recognition: connected components on the fly, redundant connection, Kruskal's MST.
**Dijkstra:** BFS with a priority queue, for non-negative weights. Negative weights → Bellman-Ford.
**Always carry a `visited` set** — forgetting it is how graph solutions become infinite loops.

### Heap / Top-K
**Core idea:** you rarely need a full sort. For "K largest," a **min-heap of size K** costs O(n log K) and O(K) memory: push each element, pop when size exceeds K, and the heap's root is the Kth largest.
**Counter-intuitive but important:** use a *min*-heap for K *largest* (the root is the weakest survivor, easiest to evict), and a max-heap for K smallest.
**Two heaps:** running median — a max-heap for the lower half, a min-heap for the upper half, kept balanced.
**Java:** `new PriorityQueue<>((a,b) -> b - a)` for max-heap; beware integer overflow in comparators with extreme values — prefer `Integer.compare(b,a)`.

### Backtracking
**Core idea:** DFS over a *state-space tree* — choose → explore → un-choose. The un-choose is what makes it backtracking rather than plain recursion.
**The template decisions:** what's the state? what are the choices at this node? when do I record an answer (leaf condition)? what makes a branch invalid (prune)?
**Pruning is the whole game:** N-Queens without pruning is 8⁸; with column/diagonal checks it's tractable. Interviewers care that you prune, not just that you enumerate.
**Complexity:** output-bound — subsets are O(2ⁿ), permutations O(n!). If n is small (≤ 20), that's your signal this is intended.
**Trap:** adding a reference to a mutable list into results instead of a copy (`new ArrayList<>(current)`).

### Greedy
**Core idea:** take the locally best choice and never reconsider. Fast (usually just a sort + one pass) — but only correct when the problem has the *greedy-choice property*.
**How to justify it (interviewers ask "why does greedy work here?"):** the **exchange argument** — show that any optimal solution can be transformed into your greedy one without getting worse. For interval scheduling: if an optimal solution doesn't pick the earliest-finishing interval, swapping it in never causes a conflict, so greedy is at least as good.
**Recognition:** intervals (sort by end for max non-overlapping; by start for merging), jump game, gas station, activity selection, Huffman.
**When greedy fails → DP.** Coin change with arbitrary denominations is the classic counterexample: greedy fails for {1,3,4} making 6.

### Dynamic Programming — the 5-step framework
Do these in order, every time, and DP stops being scary:
1. **State** — what does `dp[i]` (or `dp[i][j]`) *mean*? Write it as an English sentence. Getting this wrong dooms everything after.
2. **Transition** — how does the state build from smaller states? This is the recurrence.
3. **Base case** — the smallest inputs, set directly.
4. **Order** — bottom-up iteration order (or top-down memo, which frees you from ordering).
5. **Answer** — which cell holds the result (not always the last one).

**Recognition:** overlapping subproblems + optimal substructure. In practice: "count the ways", "min/max cost", "is it achievable", and a brute-force recursion that recomputes the same arguments.
**Start top-down.** Write the recursion, add a memo map — that's already DP and is far easier to derive under pressure than bottom-up tables. Convert to bottom-up only if asked about space.
**The families worth knowing cold:** 1D linear (climbing stairs, house robber), knapsack (0/1 and unbounded — coin change), subsequences (LCS, LIS), grid paths, interval DP.
**Space optimisation:** if `dp[i]` only reads `dp[i-1]` and `dp[i-2]`, two variables replace the array — a classic follow-up.

### Bit Manipulation
`x & 1` parity · `x >> 1` halve · `x & (x-1)` clears lowest set bit (count bits, power-of-two check) · `x ^ x = 0` (find the single non-duplicate) · `1 << i` mask for subsets.
**Recognition:** "constant space" with duplicates → XOR; "all subsets" with n ≤ 20 → bitmask.

---

## 4. THE 60-SECOND ROUTINE (use this in every round)

1. **Restate** the problem and confirm one example.
2. **Read constraints aloud** → state your target complexity ("n is 10⁵, so I need n log n or better").
3. **Name the brute force** and its complexity — never skip this; it buys goodwill and a fallback.
4. **Match the phrasing to the recognition table** → name your pattern out loud.
5. **State the invariant** ("my window stays valid because…") — this is the senior signal.
6. **Code while narrating.**
7. **Dry-run** the example, then edge cases: empty, single element, duplicates, negatives, overflow.
8. **State final time and space** unprompted.

Silence is what fails interviews, not a wrong first idea. Talking through steps 1–5 wins partial credit even if the code doesn't finish.

---

## 5. WEAK-SPOT MAP (personal)

From `GAPS_AND_ROADMAP.md`, the patterns needing the most theory-plus-reps for me:
- **Graph traversal** — never coded BFS/DFS on a real graph (Udemy course only did tree traversal). Highest priority.
- **Backtracking** — recursion covered, state-space pruning not.
- **Sliding window / two pointers as *named* patterns** — used implicitly, never drilled deliberately.
- **Heaps** — PriorityQueue fluency and the min-heap-for-K-largest inversion.
- **DP** — scaffolded (Q01–Q19) but needs the 5-step framework applied out loud.

Strengths to keep warm via the revision queue, not relearn: arrays, binary search (deep — 0017–0031), sorting, strings, stack/queue, hashing.
