# Linked List — Quick Recall

Status: gap-filler starter sheet (see `GAPS_AND_ROADMAP.md`). Treat this as a skeleton to practice from, not a finished topic.

## Node definition

**Java**
```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}
```

**Kotlin**
```kotlin
class ListNode(var `val`: Int, var next: ListNode? = null)
```
Note the backtick-escaped `` `val` `` — `val` is a reserved keyword in Kotlin, this is the #1 thing that trips Java devs up here. Also note `next` is nullable (`ListNode?`) — Kotlin forces you to be explicit about the end-of-list case that Java lets you ignore until a NullPointerException.

## Reverse a linked list (iterative) — the single most-asked LL question

**Java**
```java
ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}
```

**Kotlin**
```kotlin
fun reverse(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr = head
    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    return prev
}
```

## Detect cycle — Floyd's (slow/fast pointer)

**Java**
```java
boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

**Kotlin**
```kotlin
fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow === fast) return true   // referential equality, not ==
    }
    return false
}
```
In Kotlin, `==` calls `equals()`; for reference comparison on objects use `===`. This matters for cycle detection and any "same node" check.

## Find middle node (slow/fast)
Same two-pointer skeleton as cycle detection — when `fast` reaches the end, `slow` is at the middle. Reuse the pattern above with `return slow` instead of a boolean.

## Merge two sorted lists

**Java**
```java
ListNode merge(ListNode a, ListNode b) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (a != null && b != null) {
        if (a.val <= b.val) { tail.next = a; a = a.next; }
        else { tail.next = b; b = b.next; }
        tail = tail.next;
    }
    tail.next = (a != null) ? a : b;
    return dummy.next;
}
```

**Kotlin**
```kotlin
fun merge(a0: ListNode?, b0: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var tail = dummy
    var a = a0; var b = b0
    while (a != null && b != null) {
        if (a.`val` <= b.`val`) { tail.next = a; a = a.next }
        else { tail.next = b; b = b.next }
        tail = tail.next!!
    }
    tail.next = a ?: b
    return dummy.next
}
```
`a ?: b` (Elvis operator) replaces the Java ternary-for-null pattern — use this whenever you see `x != null ? x : y` in your Java solutions and want the idiomatic Kotlin version.

## Remove Nth node from end — dummy + two pointers, one pass
Use a dummy node before head, advance a `fast` pointer N+1 steps, then move `slow` and `fast` together until `fast` hits null — `slow.next` is the node to remove.

## Practice queue (work these in order)
1. Reverse a linked list (iterative, then recursive)
2. Detect + find start of cycle
3. Merge two sorted lists
4. Remove Nth from end
5. Palindrome linked list (reverse second half + compare)
6. Reorder list / merge two halves alternately
7. LRU Cache (doubly linked list + HashMap — ties directly into your existing 0107/0108 hashing work)
