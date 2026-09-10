public class RotateList {
    // Step 2: Create nodes and link them

    void main() {
        // Build the list HERE
        Node head = new Node(1, new Node(2, new Node(3, null)));

        print(head);                          // before: 1 → 2 → 3 → null

        head = rotateRight(head, 1);

        print(head);                          // after: 3 → 1 → 2 → null
    }

    // Print now takes head as parameter
    void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " → ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static class Node {
        int value;
        Node next;
        Node() {}
        Node(int value) {
            this.value = value;
        }
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }



    public Node rotateRight(Node head, int k) {
        // Edge cases
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            length++;
            tail = tail.next;
        }
        // tail is now at the last node

        // Step 2: Handle k > length
        k = k % length;
        if (k == 0) return head;

        // Step 3: Find the break point (length - k - 1 steps from head)
        Node newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // Step 4: Rewire
        Node newHead = newTail.next;   // this becomes the new head
        newTail.next = null;           // break the chain
        tail.next = head;              // old tail → old head

        return newHead;                // return the NEW head
    }
}
