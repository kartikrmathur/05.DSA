# Tree Traversal (BFS & DFS on a BST) — Course: Java DSA + LeetCode (Scott Barrett, Udemy)

Verified against the real course curriculum. Important correction versus the earlier scaffold guess: **the course's BFS/DFS lectures live here, applied to a tree — not under Graphs (`0128`).** Graphs in this course never gets traversed.

Core build, exact lecture order:
- [ ] Tree Traversal: Intro
- [ ] BFS (Breadth First Search): Intro
- [ ] BFS: Code
- [ ] DFS (Depth First Search): PreOrder — Intro
- [ ] DFS: PreOrder — Code
- [ ] DFS: PostOrder — Intro
- [ ] DFS: PostOrder — Code
- [ ] DFS: InOrder — Intro
- [ ] DFS: InOrder — Code

Recall fast: BFS uses a Queue (level by level — connects to your `0071` Queue work). All 3 DFS orders use the same recursive shape, only the position of "visit node" moves: PreOrder = visit, left, right. InOrder = left, visit, right (gives sorted order for a BST — useful fact to say out loud in interviews). PostOrder = left, right, visit.

Interview questions for tree traversal are tracked in `0125` (Validate BST, Kth Smallest Node) — both depend on InOrder traversal specifically.

Starter skeleton: `code/TreeTraversal.java`.
