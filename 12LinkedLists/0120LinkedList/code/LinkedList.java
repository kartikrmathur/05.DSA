/**
 * LINKED LIST — Complete Implementation
 * ======================================
 * Combined from LinkedList.java (Barrett/Udemy style) + Linked.java (student notes)
 *
 * Core idea: each Node holds data + a pointer (next) to the next node.
 * We track head (first node), tail (last node), and length.
 *
 * KEY CONCEPT: This is instance-based (NOT static).
 * That means you can create multiple independent lists:
 *   LinkedList list1 = new LinkedList(10);
 *   LinkedList list2 = new LinkedList(99);
 * Static design (Linked.java's approach) breaks this — only one list can exist.
 */

public class LinkedList {

    // ─────────────────────────────────────────
    // LIST STATE
    // ─────────────────────────────────────────
    private Node head;   // points to first node
    private Node tail;   // points to last node
    private int length;  // number of nodes

    // ─────────────────────────────────────────
    // NODE — the building block of a Linked List
    // ─────────────────────────────────────────
    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    // ─────────────────────────────────────────
    // CONSTRUCTOR
    // Creates a list with one starting node
    // ─────────────────────────────────────────
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // ─────────────────────────────────────────
    // PRINT — visualize the list (from Linked.java)
    // Essential for debugging and understanding pointer flow
    // ─────────────────────────────────────────
    public void print() {
        Node temp = head;
        System.out.print("[ ");
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" ]   length: " + length);
    }

    // ─────────────────────────────────────────
    // UTILITY
    // ─────────────────────────────────────────
    public void getHead()   { System.out.println("Head: " + (head == null ? "null" : head.value)); }
    public void getTail()   { System.out.println("Tail: " + (tail == null ? "null" : tail.value)); }
    public void getLength() { System.out.println("Length: " + length); }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    // ─────────────────────────────────────────
    // APPEND — add at the END         O(1)
    // ─────────────────────────────────────────
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;  // link old tail → new node
        }
        tail = newNode;           // update tail pointer
        length++;
    }

    // ─────────────────────────────────────────
    // PREPEND — add at the BEGINNING   O(1)
    // ─────────────────────────────────────────
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
        } else {
            newNode.next = head;  // new node points to old head
        }
        head = newNode;           // update head pointer
        length++;
    }

    // ─────────────────────────────────────────
    // REMOVE LAST                      O(n)
    // TWO-POINTER technique: temp walks ahead, pre follows behind
    // When temp reaches the last node, pre is at second-to-last
    // ─────────────────────────────────────────
    public Node removeLast() {
        if (length == 0) return null;

        Node temp = head;
        Node pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;   // cut the last node off
        length--;

        if (length == 0) {  // list is now empty
            head = null;
            tail = null;
        }
        return temp;        // return the removed node
    }

    // ─────────────────────────────────────────
    // REMOVE FIRST                     O(1)
    // ─────────────────────────────────────────
    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;   // disconnect the removed node
        length--;

        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    // ─────────────────────────────────────────
    // GET — retrieve node at index     O(n)
    // Foundation for set(), insert(), remove()
    // ─────────────────────────────────────────
    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // ─────────────────────────────────────────
    // SET — update value at index      O(n)
    // Reuses get() — clean and simple
    // ─────────────────────────────────────────
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // ─────────────────────────────────────────
    // INSERT — add at any position     O(n)
    // Handles 3 cases: beginning, end, middle
    // ─────────────────────────────────────────
    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0)      { prepend(value); return true; }
        if (index == length) { append(value);  return true; }

        Node newNode = new Node(value);
        Node temp = get(index - 1);   // get node BEFORE insertion point
        newNode.next = temp.next;     // new node → next node
        temp.next = newNode;          // prev node → new node
        length++;
        return true;
    }

    // ─────────────────────────────────────────
    // REMOVE — delete at any position  O(n)
    // ─────────────────────────────────────────
    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0)           return removeFirst();
        if (index == length - 1)  return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;  // skip over the removed node
        temp.next = null;
        length--;
        return temp;
    }

    // ─────────────────────────────────────────
    // REVERSE — reverse the entire list  O(n)
    // THREE-POINTER technique: before, temp, after
    // Most common linked list interview question!
    //
    // Before:  head → 1 → 2 → 3 → 4 → tail
    // After:   head → 4 → 3 → 2 → 1 → tail
    // ─────────────────────────────────────────
    public void reverse() {
        // Step 1: swap head and tail
        Node temp = head;
        head = tail;
        tail = temp;

        // Step 2: flip all next pointers
        Node before = null;
        Node after;
        for (int i = 0; i < length; i++) {
            after = temp.next;   // save next before overwriting
            temp.next = before;  // flip the pointer
            before = temp;       // move before forward
            temp = after;        // move temp forward
        }
    }

    public Node addTwoNumbers(Node l1, Node l2) {

        Node slow = l1;
        Node fast = l2;

        System.out.print(l1);
        System.out.print(l2);

        return l1;
    }

}
