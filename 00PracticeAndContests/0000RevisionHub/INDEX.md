# DSA Master Index — Java/Kotlin SDE Prep

Entry point for fast recall. Every existing topic in `05. DSA` mapped to category, complexity, and path. Nothing in the numbered folders was moved or renamed — this is a navigation layer on top.

How to use this before an interview: scan the category you're weak in, open the `code/` path, re-derive the solution from scratch without looking, then check against the saved file. Update `PROGRESS_TRACKER.md` after.

## Legend
Confidence is tracked separately in `PROGRESS_TRACKER.md`. This file is the map; that file is the log.

---

## 1. Java Fundamentals (0001–0010)

| # | Topic | Path |
|---|---|---|
| 0001 | Programming Language basics | `0001 - Programming Language` |
| 0002 | Program Flow, pseudocode | `0002 - Program Flow` |
| 0003 | How Java compiles (JVM/bytecode) | `0003 - How Java Program compiles` |
| 0004 | Writing your first program | `0004 - Writing your first program` |
| 0005 | Java being Java (quirks, data types) | `0005 - Java Being Java` |
| 0006 | Operators and Inputs | `0006 - Operators and Inputs` |
| 0007 | Packages and Modifiers | `0007 - Packages and Modifiers` |
| 0008 | Flow control and Loops | `0008 - Flow control and Loops` |
| 0009 | Functions | `0009 - Functions` |
| 0010 | Mini Project 1 (Calculator) | `0010 - Mini Project-1` |

## 2. Math & Bit Manipulation (0011–0015)

| # | Topic | Path |
|---|---|---|
| 0011 | Maths for DSA — part 1 | `0011 - Maths for DSA` |
| 0012 | Maths for DSA — part 2 | `0012 - Maths for DSA` |
| 0013 | Bits and Binary Operations | `0013 - Bits and Binary Operations` |
| 0014 | Bit Manipulation Tips (XOR tricks, masks) | `0014 - Bits Manipulation Tips` |
| 0015 | Interview Qs on Bit Manipulation | `0015 - Interview Questions on Bit Manipulation` |

**Recall fast:** `n & (n-1)` clears lowest set bit · `n & -n` isolates lowest set bit · `n ^ n = 0` · check power of 2 via `(n & (n-1)) == 0`.

## 3. Arrays (0016, 0045–0047)

| # | Topic | Path |
|---|---|---|
| 0016 | Array in one shot | `0016 - Array in one shot` |
| 0045 | Missing Number | `0045 - Missing Number` |
| 0046 | Find All Numbers Disappeared in Array | `0046 - Find All Numbers Disappeared in Array` |
| 0047 | Find Single and All Duplicates | `0047 - Find Single and All duplicates` |

## 4. Searching (0017–0031)

| # | Topic | Pattern | Path |
|---|---|---|---|
| 0017 | Linear Search | O(n) scan | `0017 - Linear Search` |
| 0018 | Binary Search | O(log n) | `0018 - Binary Search` |
| 0019 | Questions on Binary Search | — | `0019 - Questions on Binary Search` |
| 0020 | Binary Search on Infinite Array | unbounded BS | `0020 - Binary Search on Infinite Array` |
| 0021 | Binary Search on Bitonic Array | — | `0021 - Binary Search on Bitonic Array` |
| 0022 | Rotated Sorted Array | — | `0022 - Rotated Sorted Array` |
| 0023 | Hard Questions (Binary Search) | — | `0023 - Hard Questions` |
| 0024 | Koko Eating Bananas | **BS on Answer** | `0024 - Koko Eating Bananas` |
| 0025 | Smallest Divisor in Given Threshold | **BS on Answer** | `0025 - Smallest Divisor in Given Threshold` |
| 0026 | Minimize Maximum of Products | **BS on Answer** | `0026 - Minimize Maximum of Products` |
| 0027 | Aggressive Cows | **BS on Answer** | `0027 - Aggressive Cows` |
| 0028 | Median of Two Sorted Arrays | hard, O(log min(n,m)) | `0028 - Median of two Sorted Arrays` |
| 0029 | Find Kth Element of Two Sorted Arrays | — | `0029 - Find Kth element of Two Sorted Arrays` |
| 0030 | Single Element and Square Root | — | `0030 - Single Element and Square Root` |
| 0031 | Other Search Algorithms (ternary/jump/exp) | — | `0031 - Other Search Algorithm` |

**Recall fast — "Binary Search on Answer" template:** when the question says *minimize the max* or *maximize the min*, binary search over the **answer space**, not the array. `while(lo<=hi){ mid=lo+(hi-lo)/2; if(isFeasible(mid)) hi=mid-1 /*shrink*/ else lo=mid+1; }`

## 5. Matrix (0032–0036)

| # | Topic | Path |
|---|---|---|
| 0032 | Median of a Matrix | `0032 - Median of a Matrix` |
| 0033 | Smallest Kth Element of Matrix | `0033 - Smallest Kth Element of Matrix` |
| 0034 | Search in Sorted Matrix | `0034 - Search in Sorted Matrix` |
| 0035 | Transpose and Rotate a Matrix | `0035 - Transpose and Rotate a Matrix` |
| 0036 | Spiral Matrix | `0036 - Spiral Matrix` |

## 6. Complexity Theory (0037)

| # | Topic | Path |
|---|---|---|
| 0037 | Time and Space Complexity | `0037 - Time and Space Complexity` |

## 7. Sorting (0038–0044, 0118)

| # | Topic | Stable? | Time | Path |
|---|---|---|---|---|
| 0038 | Insertion Sort | Yes | O(n²) | `0038 - Insertion Sort` |
| 0039 | Selection Sort | No | O(n²) | `0039 - Selection Sort` |
| 0040 | Bubble & Brick Sort | Yes | O(n²) | `0040 - Bubble and Brick Sort` |
| 0041 | Counting Sort | Yes | O(n+k) | `0041 - Counting Sort` |
| 0042 | Radix Sort | Yes | O(d·(n+k)) | `0042 - Radix Sort` |
| 0043 | Pigeonhole Sort | Yes | O(n+range) | `0043 - Pigeonhole Sort` |
| 0044 | Cycle Sort | No | O(n²) worst, O(n) swaps | `0044 - Cycle Sort` |
| 0118 | Bucket Sort | Depends | O(n+k) avg | `0118 - Bucket Sort` |

**Note:** Merge Sort, Quick Sort, Heap Sort are referenced in the README but have no dedicated numbered folder — there's a `prc/Merge.java` and `prc/Quick.java` scratch file only. Treat these as a revision gap (see `GAPS_AND_ROADMAP.md`) even though they're "classic" — comparison-based O(n log n) sorts come up constantly in interviews.

## 8. Strings (0048–0056)

| # | Topic | Path |
|---|---|---|
| 0048 | Introduction to Strings | `0048 - Introduction to Strings` |
| 0049 | String functions, builder, buffer | `0049 - String functions, builder and buffer` |
| 0050 | String formatting + BufferedReader | `0050 - string formatting and buffered reader` |
| 0051 | Print All Substrings | `0051 - Print All Substrings` |
| 0052 | Reverse Strings | `0052 - Reverse Strings` |
| 0053 | Palindrome String | `0053 - Palindrome String` |
| 0054 | Reverse Words in a String — 1 | `0054 - Reverse Words in a String-1` |
| 0055 | Anagrams | `0055 - Anagrams` |
| 0056 | Reverse Words in a String — 3 | `0056 - Reverse Words in a String-3` |

## 9. Stack & Queue (0057–0073)

| # | Topic | Pattern | Path |
|---|---|---|---|
| 0057 | Stacks in one shot | — | `0057 - Stacks in one shot` |
| 0058 | Valid Parentheses | matching pairs | `0058 - Valid Parentheses` |
| 0059 | Count the Reversals | — | `0059 - Count the Reversals` |
| 0060 | Minimum Add to Make Parentheses Valid | — | `0060 - Minimum Add to make parentheses Valid` |
| 0061 | Minimum Swaps to Balance String | — | `0061 - Minimum Number of Swaps to balance String` |
| 0062 | Minimum Adjacent Swaps for Bracket Balancing | — | `0062 - Minimum Adjacent Swaps for bracket balancing` |
| 0063 | Asteroid Collisions | stack simulation | `0063 - Asteroids Collisions` |
| 0064 | Stock Span Problem | **monotonic stack** | `0064 - Stock Span Problem` |
| 0065 | Next Greater Element | **monotonic stack** | `0065 - Next Greater Element` |
| 0066 | Help Classmates | monotonic stack | `0066 - Help Classmates` |
| 0067 | Next Greater/Smaller — Circular Array | monotonic stack | `0067 - Next Greater-Smaller Element in circular Array` |
| 0068 | Largest Rectangle in Histogram | **hard**, monotonic stack | `0068 - Largest Rectangle in Histogram` |
| 0069 | Maximal Rectangle | hard, builds on 0068 | `0069 - Maximal Rectangle` |
| 0070 | Longest Valid Parentheses | stack/DP | `0070 - Longest Valid Parentheses` |
| 0071 | Queue Data Structure (Queue/Deque/Circular Queue) | — | `0071 - Queue Data Structure` |
| 0072 | Queue using Stacks | — | `0072 - Queue using Stacks` |
| 0073 | Stack using Queues | — | `0073 - Stack using Queues` |

**Recall fast — monotonic stack template:** for "next greater element" style problems, iterate, and while `stack.peek() < current`, pop and resolve; then push current.

---

## ⚠️ Gap: 0074–0106 are not recorded

This is where Linked List, Trees, Recursion-proper, Heaps, and Graphs would normally sit in a sequential course. They don't exist as numbered topics here. See `GAPS_AND_ROADMAP.md` — this is the single highest-leverage thing to fix before interviews, since Trees/Graphs/LinkedList are asked as often as arrays/strings.

---

## 10. Hashing (0107–0117)

| # | Topic | Path |
|---|---|---|
| 0107 | HashMap in Java | `0107 - HashMap in Java` |
| 0108 | Code Your Own HashMap | `0108 - Code Your Own HashMap` |
| 0109 | Most Frequent Element | `0109 - Most Frequent Element` |
| 0110 | Array Subset of Another Array | `0110 - ArraySubsetOfAnotherArray` |
| 0111 | Count Pairs With Given Sum | `0111 - Count Pairs With Given Sum` |
| 0112 | HashSet Intro | `0112 - HashSet Intro` |
| 0113 | Minimum Number of Distinct Sets | `0113 - Minimum Number Of Distinct Sets` |
| 0114 | K-Sum Subarray Pattern | `0114 - K-Sum Subarray Pattern` |
| 0115 | Subarray Sum Divisible by K | `0115 - Subarray Sum Divisible by K` |
| 0116 | Longest Consecutive Sequence | `0116 - LongestConsecutiveSequence` |
| 0117 | Longest Subarray of 0 & 1 | `0117 - Longest Subarray of 0 & 1` |

## 11. Dynamic Programming (0119)

All 19 sub-problems live as `Q01`–`Q19` files inside `0119 - Dynamic Programming`:

| Q | Problem | DP Pattern |
|---|---|---|
| Q01 | Fibonacci | 1D, memoization intro |
| Q02 | Climbing Stairs | 1D |
| Q03 | Counting Bits | 1D bitwise |
| Q04 | Min Cost Climbing Stairs | 1D |
| Q05 | House Robber 1 | 1D, non-adjacent |
| Q06 | House Robber 2 | 1D, circular variant |
| Q07 | Check Subsequence with Sum K | subset/2D |
| Q08 | Perfect Sum | subset/2D |
| Q09 | 0/1 Knapsack | 2D, the classic |
| Q10 | Coin Change | unbounded knapsack |
| Q11 | Coin Change 2 | unbounded knapsack (count ways) |
| Q12 | Rod Cutting | unbounded knapsack |
| Q13 | Longest Common Subsequence | 2D strings |
| Q14 | Longest Palindromic Subsequence | 2D strings |
| Q15 | Shortest Common Supersequence | 2D strings, builds on LCS |
| Q16 | Longest Increasing Subsequence | 1D / O(n log n) variant |
| Q17 | Longest Length of Pair Chain | LIS variant |
| Q18 | Unique Paths 1 | 2D grid |
| Q19 | Unique Paths 2 (with obstacles) | 2D grid |

**Recall fast:** every DP problem = (1) define state, (2) write recurrence in terms of smaller state, (3) base case, (4) decide top-down memo vs bottom-up table. If stuck, brute-force recursion first, then add memoization.

---

## 12. Gap-fill from "Java DSA + LeetCode" (Scott Barrett, Udemy) — 0120–0136

You completed this course already, but the code was on the laptop that got formatted — Udemy doesn't store your written exercises, only the curriculum, so these are rebuilt scaffolds (checklist + TODO-stub code), not recovered solutions. Source: https://www.udemy.com/course/data-structures-and-algorithms-java/ (course id 4218796). Every row below is now verified against the real course curriculum (41 sections / 150 lectures, pulled directly) — the earlier "best-effort guess" caveat is resolved. Sections this course also covers but you already have deep, redundant coverage of (Big O, Classes & References, Stacks/Queues, Hash Tables, Basic Sorts) were **not** duplicated here — only the genuine gaps got numbered folders.

| # | Topic | Path |
|---|---|---|
| 0120 | Linked List (core build) | `0120 - Linked List` |
| 0121 | Linked List Interview Questions (8 problems) | `0121 - Linked List Interview Questions` |
| 0122 | Doubly Linked List (core build) | `0122 - Doubly Linked List` |
| 0123 | Doubly Linked List Interview Questions (5 problems) | `0123 - Doubly Linked List Interview Questions` |
| 0124 | Binary Trees — BST, iterative (core build) | `0124 - Binary Trees` |
| 0125 | Binary Trees Interview Questions (4 real + bonus) | `0125 - Binary Trees Interview Questions` |
| 0126 | Heaps (array-backed, from scratch) | `0126 - Heaps` |
| 0127 | Heaps Interview Questions (2 real + bonus) | `0127 - Heaps Interview Questions` |
| 0128 | Graphs — structural CRUD only, no traversal in this course | `0128 - Graphs` |
| 0129 | Graphs Interview Questions — **this chapter doesn't exist in the course**, use CHEATSHEETS instead | `0129 - Graphs Interview Questions` |
| 0130 | Recursion (course chapter is just 3 lectures; your loose `Recursion/` folder is deeper) | `0130 - Recursion` |
| 0131 | Merge Sort & Quick Sort (+ 1 LL interview question) | `0131 - Merge Sort and Quick Sort` |
| 0132 | Recursive Binary Search Trees (insert/contains/delete) | `0132 - Recursive Binary Search Trees` |
| 0133 | Tree Traversal — BFS + 3 DFS orders (this is where the course's "BFS/DFS" actually lives, **not** under Graphs) | `0133 - Tree Traversal` |
| 0134 | Dynamic Programming Concepts (vocabulary only — your `0119` is the real depth) | `0134 - Dynamic Programming Concepts` |
| 0135 | Array Interview Exercises — course-specific (Max Profit, Max Sub Array/Kadane's, Rotate, etc.) | `0135 - Array Interview Exercises (Course)` |
| 0136 | Sorting a Linked List (Bubble/Selection/Insertion applied to LL) | `0136 - Sorting a Linked List` |

**The one correction worth remembering:** the original scaffold guessed Graphs would include BFS/DFS. It doesn't — this course's traversal lectures are entirely about trees (`0133`), and Graphs (`0128`) never gets walked. If graph algorithms come up in interviews, that's 100% on `CHEATSHEETS/Graphs.md`, not this course.

## 13. Legacy / unstructured practice (lower priority for revision)

These exist outside the numbered system — useful as extra reps, not as primary recall material:

| Folder | Contents |
|---|---|
| `Recursion/` | Factorial, Fibonacci, power, tiling, sorted-check, binary string generator — basic recursion only, no backtracking |
| `Linkedlist/` | Single stub file (`Linked.java`) — not a real implementation |
| `BitManipulation/` | Duplicate scratch versions of 0013–0015 |
| `Strings/` | Duplicate scratch versions of 0048–0056 |
| `Tcs/Array/` | TCS-NQT style array drill questions |
| `Questions/` | Mixed array/string warmups |
| `basics/`, `basics -2/`, `oops/`, `prc/`, `ese/` | Early Java syntax practice, OOP start, sort scratch (`prc` has Merge.java/Quick.java/Sr.java) |

## 14. Kotlin

Almost everything above is Java only — the only Kotlin DSA scaffolds so far are `.kt` starter files in `0120 - Linked List` and `0122 - Doubly Linked List` (do the Java version first, then port, per their notes). `07.LeetCode/Parking Lot` is actually a Hyperskill **Kotlin language fundamentals** course (in progress as of mid-June 2026), not algorithm practice. Since you're targeting Java + Kotlin roles, port a handful of solved problems per category to Kotlin as you revise — see `CHEATSHEETS/` for Java-vs-Kotlin idiom notes to make this fast.

`CHEATSHEETS/KotlinFundamentals.md` is a separate, growing note for language-fundamentals theory (not DSA patterns) — Kotlin's counterpart to the Java fundamentals notes in `0001`–`0010`. Currently has Memory Management; add a new section there whenever a Java fundamentals topic needs its Kotlin equivalent, rather than editing the cloned reference notes directly.

---

Next: open `PROGRESS_TRACKER.md` to log what you revise, and `GAPS_AND_ROADMAP.md` for what to study next.
