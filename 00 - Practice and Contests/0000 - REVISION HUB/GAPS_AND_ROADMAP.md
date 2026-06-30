# Gaps & Roadmap

What's missing from `05. DSA`, why it matters, and the order to fill it in. The numbered course jumps from Stack/Queue (0073) straight to Hashing (0107) — topics 0074–0106 were never recorded, and that gap happens to be exactly where Linked List, Trees, Heaps, and Graphs normally live.

For a 4-year Java/Kotlin SDE aiming at top-tier interviews, these aren't optional extras — Trees and Graphs alone show up in a large share of mid-to-senior interview loops, and Linked List is the most common "warm-up" question.

## Priority order

### P0 — do these first (highest interview frequency)
1. **Linked List** — currently just a stub (`Linkedlist/Linked.java`). Need: singly/doubly/circular, reversal (iterative + recursive), cycle detection (Floyd's), merge two sorted lists, remove Nth from end, find middle, palindrome check, LRU cache (combines with HashMap, which you already know).
2. **Trees** — completely absent. Need: traversals (in/pre/post-order, level-order/BFS), height/depth, diameter, LCA, BST insert/search/delete, validate BST, balanced check, serialize/deserialize.
3. **Graphs** — completely absent. Need: adjacency list representation, BFS, DFS, connected components, topological sort (Kahn's + DFS-based), Dijkstra, Union-Find (for cycle detection / Kruskal's).

### P1 — do these next
4. **Heaps / Priority Queue** — absent. Need: `PriorityQueue` usage in Java/Kotlin, top-K elements, kth largest, median of a running stream, merge K sorted lists.
5. **Backtracking** — your `Recursion/` folder covers plain recursion (factorial, fibonacci, tiling) but not backtracking. Need: subsets, permutations, combination sum, N-Queens, Sudoku solver, word search.
6. **Sliding Window / Two Pointer** — used implicitly in some of your array/string problems but never named as a pattern. Worth drilling explicitly: max subarray of size k, longest substring without repeating characters, container with most water.

### P2 — finish the picture
7. **Trie** — prefix trees, autocomplete-style problems, word search II.
8. **Greedy** — interval scheduling, jump game, gas station.
9. **Classic O(n log n) sorts as real implementations** — Merge Sort, Quick Sort, Heap Sort are mentioned in your README but only exist as unfinished scratch files (`prc/Merge.java`, `prc/Quick.java`). Worth writing clean versions since they're a frequent "implement from scratch" ask.

## Update: scaffolds for P0/P1 now exist and are verified (0120–0136)
You confirmed you'd already completed "Java DSA + LeetCode" (Scott Barrett, Udemy, https://www.udemy.com/course/data-structures-and-algorithms-java/, course id 4218796) — but the code was lost in the laptop format. Rebuilt scaffolds (checklists + TODO-stub code, continuing the existing numbering) live at `0120`–`0136`. These are now pulled from the **real course curriculum** (41 sections, 150 lectures, fetched directly) — no more best-effort guessing.

Three corrections worth knowing, since they change what you can rely on this course for:
1. **Graphs has no traversal.** The "Graphs" chapter (`0128`) is purely structural — add/remove vertex/edge, adjacency list vs matrix. BFS/DFS in this course is entirely under Tree Traversal (`0133`), applied to a BST. If you only did this course, you have never actually coded a graph BFS/DFS — that's still 100% true and now confirmed, not assumed.
2. **There is no Graph interview-questions chapter at all** (`0129` — corrected to reflect this directly; no Number of Islands, no Course Schedule, no Clone Graph in this course).
3. **Heaps interview questions are only 2 problems** (Kth Smallest Element in an Array, Maximum Element in a Stream) — not the 4 I'd guessed.

Everything else (Linked List, Doubly Linked List, Binary Trees/rBST/Traversal, Heaps core build, Recursion, Merge/Quick Sort, plus the previously-unscaffolded Dynamic Programming Concepts, Array Interview Exercises, and Sorting-a-Linked-List chapters at `0132`–`0136`) now matches the real lecture-by-lecture structure exactly.

## Update: reference code from another student's repo added (2026-06-20)
You explicitly asked me to clone one of the two student repos rather than wait on checking your Udemy-saved submissions. I compared both: `Phlipr/DSA` (9 commits, "Completed course" as final message but several core folders like Heaps/DP/Recursion never actually got their own files) vs `ivan-zykov/udemy-dsa-barrett` (46 commits, cleaner one-folder-per-topic structure, a `cheatsheets` folder of their own). Went with **ivan-zykov's repo** — more granular and more complete.

Important: **neither repo has a Heaps folder or a Dynamic Programming folder at all.** Both students appear to have stopped (or skipped ahead in a way that skipped local-repo commits) before those chapters. So this didn't close the Heaps/DP gap — `0126`/`0127`/`0134` and your existing `0119` remain the only material for those, same as before.

What got added, all explicitly labeled `Reference_ivanzykov_*` and NOT your own work:
- `0120/code/Reference_ivanzykov_LinkedList.java`
- `0122/code/Reference_ivanzykov_DoublyLinkedList.java`
- `0124/code/Reference_ivanzykov_BinarySearchTree.java` (covers `0124`'s insert/contains AND `0133`'s BFS/DFS traversal in one file — no delete, so no help for `0132`)
- `0128/code/Reference_ivanzykov_Graph.java` (confirms independently: no graph traversal, matching the real curriculum)
- `0131/code/Reference_ivanzykov_MergeSort.java` (has a real bug, deliberately left in and flagged in a comment — good spot-the-bug practice) and `Reference_ivanzykov_QuickSort.java`

None of these were copied into your `LinkedList.java`/`DoublyLinkedList.java`/etc. stub files — those stay empty for you to fill in. Each checklist now tells you to write your own attempt first, then diff against the reference. If you skip straight to reading the reference, the confidence ratings in `PROGRESS_TRACKER.md` stop meaning anything.

What's left after P0/P1: Backtracking, Sliding Window/Two Pointer, Trie, Greedy, and graph algorithms (BFS/DFS-on-graphs, Dijkstra, Union-Find, Topological Sort) — confirmed none of these are in the Udemy course, so `CHEATSHEETS/Patterns.md` and `CHEATSHEETS/Graphs.md` remain your primary (and only) scaffold for them.

## Where to put further new work
Keep following the existing convention: `notes/` + `code/` subfolders, numbered continuing from `0137`. Then add a row to `INDEX.md` and `PROGRESS_TRACKER.md`.

## Starter material already provided
`CHEATSHEETS/` in this folder has quick-recall pattern sheets (concept + Java **and** Kotlin templates) for Linked List, Trees, Heaps, Graphs, and the Backtracking/Sliding-Window/Trie/Greedy patterns — so you have something to revise immediately, before you've recorded full notes for these topics. Treat them as a starting skeleton, not a replacement for working through real problems on each.

## Kotlin specifically
Every one of the 119 existing topics is Java-only. As a Java+Kotlin candidate, the fastest ROI isn't rewriting everything — it's being fluent in the Kotlin-specific idioms interviewers probe for (data classes vs POJOs, `when` vs switch, null-safety in recursive structures, `MutableList`/`ArrayDeque` vs `ArrayList`/`LinkedList`, scope functions). `CHEATSHEETS/Patterns.md` and each DS cheat-sheet include a Kotlin column for this reason — use them to translate 3-5 already-solved Java problems per category into Kotlin as part of revision, rather than starting from zero.
