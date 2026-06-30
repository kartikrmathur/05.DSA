# Merge Sort & Quick Sort — Course: Java DSA + LeetCode (Scott Barrett, Udemy)

Verified against the real course curriculum — these are two separate chapters, exact lecture order:

**Merge Sort**
- [ ] Merge Sort: Overview
- [ ] Merge: Intro
- [ ] Merge: Code
- [ ] Merge Sort: Intro
- [ ] Merge Sort: Code
- [ ] Merge Sort: Big O
- [ ] Interview exercise: **LL — Merge Two Sorted Lists** (the course's one interview question for this chapter — connects directly to your `0120` Linked List work, and to the merge-K-lists heap problem in `0127`'s bonus list)

**Quick Sort**
- [ ] Quick Sort: Intro
- [ ] Pivot: Intro
- [ ] Pivot: Code
- [ ] Quick Sort: Code
- [ ] Quick Sort: Big O

You already have Bubble/Selection/Insertion (0038–0040) plus the non-comparison sorts (Counting/Radix/Pigeonhole/Cycle/Bucket: 0041–0044, 0118) — Merge Sort and Quick Sort were the actual gap, flagged in `00000 - REVISION HUB/GAPS_AND_ROADMAP.md`, and you only had unfinished scratch versions in the loose `prc/` folder.

Starter skeleton: `code/Sorts.java`. Be ready to explain, for both: time/space complexity (best/average/worst), whether it's stable, and why you'd pick one over the other (Quick Sort generally faster in practice due to cache locality and no extra allocation; Merge Sort preferred when stability matters or for linked lists, where Quick Sort's random access advantage disappears).

`code/Reference_ivanzykov_MergeSort.java` and `code/Reference_ivanzykov_QuickSort.java` are another student's repo for this same course, pulled in at your request. The MergeSort one has a real bug in it (flagged in a comment in that file) — find it yourself before reading the comment, it's good practice for code review skills, not just recall.
