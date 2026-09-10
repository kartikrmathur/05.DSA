# Linked List Masterclass - The Only Guide You'll Ever Need

---

## 1. What is a Linked List?

A train. Each coach (node) carries a passenger (value) and has a coupling (pointer) to the next coach.

```
[10 | next] → [20 | next] → [30 | next] → null
  ↑
 head (this is ALL you're given)
```

You can only enter the train from the engine (head). To reach coach 3, you MUST walk through coach 1 and 2. No shortcuts.

---

## 2. The Node - Memorize This Forever

```java
class ListNode {
    int val;           // the data
    ListNode next;     // pointer to next node (or null)

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
```

That's it. A linked list is just a bunch of these connected via `.next`.

---

## 3. The 4 Core Operations (Everything Builds On These)

### TRAVERSE - Walk the list
```java
ListNode current = head;
while (current != null) {
    System.out.println(current.val);
    current = current.next;     // move to next node
}
```
**Golden rule:** `current = current.next` moves you forward. That's how you "iterate" a linked list.

---

### INSERT - Add a node

**At head (O(1)):**
```java
ListNode newNode = new ListNode(5);
newNode.next = head;    // new node points to old head
head = newNode;         // new node becomes head
```

**After a given node (O(1)):**
```java
ListNode newNode = new ListNode(5);
newNode.next = prev.next;   // new node points to what prev pointed to
prev.next = newNode;         // prev now points to new node
```

**ORDER MATTERS!** Always set `newNode.next` BEFORE changing `prev.next`, or you lose the rest of the chain.

---

### DELETE - Remove a node

```java
prev.next = prev.next.next;   // skip over the node to delete
```

That's literally it. The skipped node has no one pointing to it, so Java garbage collects it.

**Delete head:**
```java
head = head.next;
```

---

### SEARCH - Find a value

```java
ListNode current = head;
while (current != null) {
    if (current.val == target) return current;
    current = current.next;
}
return null;  // not found
```

---

## 4. The Length Trick

```java
int length(ListNode head) {
    int count = 0;
    while (head != null) {
        count++;
        head = head.next;
    }
    return count;
}
```

---

## 5. The 5 Patterns That Solve 90% of Problems

### PATTERN 1: Two Pointers (Slow & Fast)

One pointer moves 1 step, the other moves 2 steps.

```java
ListNode slow = head, fast = head;
while (fast != null && fast.next != null) {
    slow = slow.next;           // 1 step
    fast = fast.next.next;      // 2 steps
}
// slow is now at the MIDDLE
```

**Why it works:** When fast reaches the end, slow is at half distance.

**Use it for:**
- Find middle node
- Detect cycle (Floyd's algorithm)
- Find kth node from end
- Check palindrome

#### Detect Cycle:
```java
boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;  // they met = cycle exists
    }
    return false;
}
```

#### Find Cycle Start:
```java
ListNode detectCycleStart(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            slow = head;  // reset slow to head
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;  // both move 1 step now
            }
            return slow;  // meeting point = cycle start
        }
    }
    return null;
}
```

#### Kth Node From End:
```java
ListNode kthFromEnd(ListNode head, int k) {
    ListNode fast = head, slow = head;
    for (int i = 0; i < k; i++) fast = fast.next;  // move fast k steps ahead
    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
}
```

---

### PATTERN 2: Reverse a Linked List

**This is the most important pattern. Master it.**

#### Iterative (memorize this):
```java
ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    while (current != null) {
        ListNode next = current.next;   // save next
        current.next = prev;            // flip the arrow
        prev = current;                 // move prev forward
        current = next;                 // move current forward
    }
    return prev;  // prev is the new head
}
```

**Walk through:**
```
Original:  1 → 2 → 3 → null

Step 1: prev=null, curr=1
        null ← 1   2 → 3 → null
        
Step 2: prev=1, curr=2
        null ← 1 ← 2   3 → null
        
Step 3: prev=2, curr=3
        null ← 1 ← 2 ← 3
        
curr=null, return prev(3)
Result:    3 → 2 → 1 → null
```

#### Recursive:
```java
ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = reverse(head.next);
    head.next.next = head;   // the node after me should point back to me
    head.next = null;        // I point to null (for now)
    return newHead;
}
```

**Use it for:**
- Reverse entire list
- Reverse between position L and R
- Reverse in groups of K
- Check palindrome (reverse second half, compare)
- Reorder list

---

### PATTERN 3: Dummy Node

Create a fake head so you never have to special-case "what if head is null?"

```java
ListNode dummy = new ListNode(-1);
ListNode current = dummy;

// ... build your list by doing current.next = something ...

return dummy.next;  // skip the fake head
```

**Use it for:**
- Merge two sorted lists
- Remove duplicates
- Partition list
- Any time you're building a new list

---

### PATTERN 4: Recursion

Think of any linked list as: **head** + **rest of the list**

```
[1] → [2 → 3 → 4 → null]
 ↑          ↑
head    rest (also a linked list!)
```

Template:
```java
ReturnType solve(ListNode head) {
    // base case
    if (head == null) return ...;
    
    // recurse on the rest
    ReturnType result = solve(head.next);
    
    // do something with head and result
    ...
    
    return ...;
}
```

---

### PATTERN 5: HashMap / HashSet

When you need to remember which nodes you've seen.

#### Find Intersection of Two Lists:
```java
ListNode getIntersection(ListNode a, ListNode b) {
    Set<ListNode> visited = new HashSet<>();
    while (a != null) {
        visited.add(a);
        a = a.next;
    }
    while (b != null) {
        if (visited.contains(b)) return b;
        b = b.next;
    }
    return null;
}
```

#### Copy List with Random Pointer:
```java
// Map old node → new node, then wire up next and random
Map<Node, Node> map = new HashMap<>();
```

---

## 6. The Problem-Solving Cheat Sheet

When you see a linked list problem, ask yourself:

| If the problem says... | Use this pattern |
|---|---|
| "middle of list" | Slow/Fast pointers |
| "cycle" or "loop" | Slow/Fast (Floyd's) |
| "kth from end" | Two pointers, k apart |
| "reverse" | Three-pointer reversal |
| "palindrome" | Find middle + reverse second half + compare |
| "merge two lists" | Dummy node + compare heads |
| "remove nodes" | Dummy node + prev pointer |
| "reorder" | Find middle + reverse + merge |
| "intersection" | HashMap or align-lengths trick |
| "copy with random" | HashMap (old → new) |
| "sort a list" | Merge sort (find middle + split + merge) |
| "add two numbers" | Traverse both + carry |
| "flatten" | Recursion or stack |
| "swap nodes in pairs" | Recursion or iterative with prev |
| "rotate list" | Find length + connect tail to head + break at new point |

---

## 7. Edge Cases - Check These EVERY Time

```java
if (head == null) return null;           // empty list
if (head.next == null) return head;      // single node
// also think about: two nodes, cycle, very long list
```

---

## 8. Doubly Linked List - Same Thing, Extra Pointer

```java
class DListNode {
    int val;
    DListNode prev;
    DListNode next;
}
```

**Insert after a node:**
```java
newNode.next = node.next;
newNode.prev = node;
if (node.next != null) node.next.prev = newNode;
node.next = newNode;
```

**Delete a node (when you have the node itself):**
```java
if (node.prev != null) node.prev.next = node.next;
if (node.next != null) node.next.prev = node.prev;
```

Advantage: you can delete a node in O(1) if you have a reference to it (no need to find `prev` by traversing).

Used in: **LRU Cache** (HashMap + Doubly Linked List)

---

## 9. Java's Built-in LinkedList

```java
LinkedList<Integer> list = new LinkedList<>();
list.add(10);           // add to end
list.addFirst(5);       // add to front
list.addLast(20);       // add to end
list.get(1);            // get by index (slow, O(n))
list.remove(0);         // remove by index
list.removeFirst();     // remove head
list.removeLast();      // remove tail
list.size();            // length
list.contains(10);      // search
```

**In interviews, you'll always implement your own. But know this exists.**

---

## 10. Common Mistakes That Will Bite You

1. **NullPointerException** - Always check `node != null` before accessing `node.next` or `node.val`
2. **Losing the chain** - When rewiring, save `next` before changing pointers
3. **Forgetting to return new head** - After reversing or deleting head, the head changes
4. **Infinite loop** - When manipulating circular lists, make sure you have a termination condition
5. **Off-by-one in two pointers** - Walk through a 2-3 node example on paper first

---

## 11. Time Complexity Summary

| Operation | Singly | Doubly |
|---|---|---|
| Access by index | O(n) | O(n) |
| Insert at head | O(1) | O(1) |
| Insert at tail (with tail pointer) | O(1) | O(1) |
| Insert at middle | O(n) find + O(1) insert | O(n) find + O(1) insert |
| Delete head | O(1) | O(1) |
| Delete given node | O(n) need prev | O(1) have prev |
| Search | O(n) | O(n) |
| Reverse | O(n) | O(n) |

---

**Remember: Every linked list problem is just traversal + pointer manipulation. If you can walk the list and rewire arrows, you can solve anything.**
