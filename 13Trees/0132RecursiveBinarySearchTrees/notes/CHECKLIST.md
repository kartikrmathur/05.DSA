# Recursive Binary Search Trees (rBST) — Course: Java DSA + LeetCode (Scott Barrett, Udemy)

Verified against the real course curriculum. This is the chapter right after basic Recursion (`0130`) and right before Tree Traversal (`0133`) — the course rebuilds BST operations recursively instead of iteratively (compare against your iterative versions in `0124`).

Core build, exact lecture order:
- [ ] rBST: Contains
- [ ] rBST: Insert
- [ ] rBST: Delete — Intro
- [ ] rBST: Delete — Code (1 of 3)
- [ ] rBST: Delete — Code (2 of 3)
- [ ] rBST: Minimum Value
- [ ] rBST: Delete — Code (3 of 3)

Deletion is the hard part here — 3 lecture-parts dedicated to it for a reason. The tricky case is deleting a node with two children: you replace its value with the minimum value of its right subtree, then recursively delete that minimum-value node instead. Walk through that case by hand on paper before coding it; it's the single most-fumbled tree operation in interviews.

Interview questions for this chapter are tracked in `0125` (Convert Sorted Array to Balanced BST, Invert Binary Tree) — do this chapter first since those depend on recursive tree-building.

Starter skeleton: `code/RecursiveBST.java`.
