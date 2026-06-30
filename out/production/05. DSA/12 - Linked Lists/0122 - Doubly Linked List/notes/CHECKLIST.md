# Doubly Linked List — Course: Java DSA + LeetCode (Scott Barrett, Udemy)

Same rebuild situation as `0120 - Linked List` — original code lost, scaffold rebuilt from the public course curriculum.

Core build:
- [ ] Constructor
- [ ] Append
- [ ] Remove Last
- [ ] Prepend
- [ ] Remove First
- [ ] Get
- [ ] Set
- [ ] Insert
- [ ] Remove

Difference from singly linked list: every node also has a `prev` pointer. That's what makes `removeLast()` O(1) here instead of O(n) like in the singly-linked version — no need to walk to find the second-to-last node, just follow `tail.prev`. Calling that out explicitly when revising is a good interview talking point ("why DLL over LL here").

Starter skeletons: `code/DoublyLinkedList.java` and `code/DoublyLinkedList.kt`.

`code/Reference_ivanzykov_DoublyLinkedList.java` is another student's repo for this same course, pulled in at your request — write your own first, then diff against it.
