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
    // NODE — the building block of a Linked List
    // ─────────────────────────────────────────
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ─────────────────────────────────────────
    // LIST STATE
    // ─────────────────────────────────────────
    Node head;   // points to first node
    Node tail;   // points to last node
    int length;  // number of nodes

    // ─────────────────────────────────────────
    // CONSTRUCTOR
    // Creates a list with one starting node
    // ─────────────────────────────────────────
    public LinkedList(int data) {
        Node newNode = new Node(data);
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
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println(" ]   length: " + length);
    }

    // ─────────────────────────────────────────
    // UTILITY
    // ─────────────────────────────────────────
    public void getHead()   { System.out.println("Head: " + (head == null ? "null" : head.data)); }
    public void getTail()   { System.out.println("Tail: " + (tail == null ? "null" : tail.data)); }
    public void getLength() { System.out.println("Length: " + length); }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    // ─────────────────────────────────────────
    // APPEND — add at the END         O(1)
    // ─────────────────────────────────────────
    public void append(int data) {
        Node newNode = new Node(data);
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
    public void prepend(int data) {
        Node newNode = new Node(data);
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
    public boolean set(int index, int data) {
        Node temp = get(index);
        if (temp != null) {
            temp.data = data;
            return true;
        }
        return false;
    }

    // ─────────────────────────────────────────
    // INSERT — add at any position     O(n)
    // Handles 3 cases: beginning, end, middle
    // ─────────────────────────────────────────
    public boolean insert(int index, int data) {
        if (index < 0 || index > length) return false;
        if (index == 0)      { prepend(data); return true; }
        if (index == length) { append(data);  return true; }

        Node newNode = new Node(data);
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

    // ─────────────────────────────────────────
    // MAIN — test all operations
    // ─────────────────────────────────────────
    public static void main(String[] args) {
        LinkedList list = new LinkedList(10);

        System.out.println("=== Initial list ===");
        list.print();

        System.out.println("\n=== append 20, 30, 40 ===");
        list.append(20);
        list.append(30);
        list.append(40);
        list.print();

        System.out.println("\n=== prepend 5 ===");
        list.prepend(5);
        list.print();

        System.out.println("\n=== insert 25 at index 3 ===");
        list.insert(3, 25);
        list.print();

        System.out.println("\n=== get index 2 ===");
        System.out.println("Node at 2: " + list.get(2).data);

        System.out.println("\n=== set index 2 to 99 ===");
        list.set(2, 99);
        list.print();

        System.out.println("\n=== removeFirst ===");
        System.out.println("Removed: " + list.removeFirst().data);
        list.print();

        System.out.println("\n=== removeLast ===");
        System.out.println("Removed: " + list.removeLast().data);
        list.print();

        System.out.println("\n=== remove at index 1 ===");
        System.out.println("Removed: " + list.remove(1).data);
        list.print();

        System.out.println("\n=== reverse ===");
        list.reverse();
        list.print();

        list.getHead();
        list.getTail();
        list.getLength();
    }
}
