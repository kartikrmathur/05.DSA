# Graphs — Course: Java DSA + LeetCode (Scott Barrett, Udemy)

Verified against the real course curriculum — and the correction matters: **this course's "BFS"/"DFS" lectures are under the Tree Traversal chapter (`0133`), applied to a BST, not under Graphs.** The Graphs chapter itself is only structural CRUD on an adjacency representation — no graph BFS/DFS, no Dijkstra, no Union-Find, no topological sort. Don't assume those are covered just because "Graphs" exists as a chapter.

Core build, exact lecture order:
- [ ] Graph: Intro
- [ ] Graph: Adjacency Matrix
- [ ] Graph: Adjacency List
- [ ] Graph: Big O
- [ ] Graph: Add Vertex
- [ ] Graph: Add Edge
- [ ] Graph: Remove Edge
- [ ] Graph: Remove Vertex

That's the entire chapter — no traversal, no algorithms. For actual graph BFS/DFS/Dijkstra/Union-Find/topological sort (which interviews absolutely will ask, course gap or not), use `00000 - REVISION HUB/CHEATSHEETS/Graphs.md` — full Java + Kotlin templates there.

Starter skeleton: `code/Graph.java`.

`code/Reference_ivanzykov_Graph.java` is another student's repo for this same course, pulled in at your request — and it independently confirms the no-traversal point above (their repo doesn't have graph BFS/DFS either). Write your own first, then diff.
