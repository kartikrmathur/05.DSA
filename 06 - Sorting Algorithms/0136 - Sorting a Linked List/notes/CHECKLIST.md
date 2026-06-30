# Sorting a Linked List — Interview / LeetCode Exercises — Course: Java DSA + LeetCode (Scott Barrett, Udemy)

Verified against the real course curriculum. This is the "Basic Sorts: Interview/LeetCode Exercises" chapter — it takes Bubble/Selection/Insertion Sort (which you already know from `0038`–`0040` on arrays) and asks you to re-implement them operating on a linked list instead. Good integrative practice: combines `0120` Linked List pointer manipulation with sorting logic you already have cold.

- [ ] Bubble Sort of a Linked List
- [ ] Selection Sort of a Linked List
- [ ] Insertion Sort of a Linked List

The thing that changes versus the array version: no random access by index, so "swap" means re-linking `next` pointers (or swapping `.val` fields, which is simpler but worth knowing both approaches — interviewers sometimes specifically ask you not to swap values, only nodes).

Starter skeleton: `code/LinkedListSorts.java`.
