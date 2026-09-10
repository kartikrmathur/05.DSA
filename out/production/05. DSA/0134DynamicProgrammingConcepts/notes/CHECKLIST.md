# Dynamic Programming Concepts — Course: Java DSA + LeetCode (Scott Barrett, Udemy)

Verified against the real course curriculum. This chapter is short and purely conceptual/vocabulary — your existing `0119 - Dynamic Programming` (19 solved problems) is far deeper than this. Treat this chapter as "make sure you can define these terms cleanly out loud," not new problem-solving.

- [ ] Overlapping Subproblems — the same subproblem gets recomputed multiple times in the naive recursive solution; DP's whole value proposition is eliminating this
- [ ] Optimal Substructure — the optimal solution to the problem can be built from optimal solutions to its subproblems
- [ ] Fibonacci Sequence — the standard teaching example for both of the above
- [ ] Memoization — top-down: recursion + a cache (HashMap or array) to avoid recomputing
- [ ] Bottom Up — build the table from the base case upward, no recursion, usually the more space-efficient option

Interview framing: when asked "is this a DP problem," check for both overlapping subproblems and optimal substructure — if either is missing, DP isn't the right tool. When asked to optimize a brute-force recursive solution, memoization is the safest first move (smallest code diff); bottom-up is the next step if you need to also drop the recursion overhead.

No separate code folder needed here — apply memoization/bottom-up directly to whichever `0119` problem you're revising next, as a way of re-deriving it rather than just recalling it.
