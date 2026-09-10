import java.util.Collections;
import java.util.LinkedList;

public class Sample {

    public static void main(String[] args) {

        // Creating a LinkedList
        LinkedList<String> myLinkedList = new LinkedList<>();

        // Adding elements
        myLinkedList.add("One");
        myLinkedList.add("Two");
        myLinkedList.add("Three");
        myLinkedList.add("Four");
        myLinkedList.add("Five");

        System.out.println("Original List: " + myLinkedList);

        // Update element
        myLinkedList.set(1, "Wassssssup");
        System.out.println("After set(): " + myLinkedList);

        // Remove elements
        myLinkedList.remove("Five");
        myLinkedList.remove(3);
        System.out.println("After remove(): " + myLinkedList);

        // Using get() with for loop
        System.out.println("\nUsing get():");
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }

        // Enhanced for loop
        System.out.println("\n\nEnhanced for loop:");
        for (String str : myLinkedList) {
            System.out.print(str + " ");
        }

        System.out.println("\n");

        // Add operations
        myLinkedList.add("50");
        myLinkedList.add("100");
        myLinkedList.addAll(Collections.singleton("300"));
        myLinkedList.addAll(new LinkedList<>(myLinkedList)); // Duplicate contents
        myLinkedList.addFirst("33");
        myLinkedList.addLast("Last");

        System.out.println("After additions: " + myLinkedList);

        // Clone
        LinkedList<String> clonedList = (LinkedList<String>) myLinkedList.clone();
        System.out.println("Cloned List: " + clonedList);

        // Contains
        System.out.println("Contains '100': " + myLinkedList.contains("100"));

        // Descending Iterator
        System.out.print("Descending Order: ");
        var itr = myLinkedList.descendingIterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        // Element
        System.out.println("element(): " + myLinkedList.element());

        // Get methods
        System.out.println("get(2): " + myLinkedList.get(2));
        System.out.println("getFirst(): " + myLinkedList.getFirst());
        System.out.println("getLast(): " + myLinkedList.getLast());

        // Index methods
        System.out.println("indexOf('100'): " + myLinkedList.indexOf("100"));
        System.out.println("lastIndexOf('100'): " + myLinkedList.lastIndexOf("100"));

        // Offer methods
        myLinkedList.offer("51");
        myLinkedList.offerFirst("52");
        myLinkedList.offerLast("53");

        System.out.println("After offer methods: " + myLinkedList);

        // Peek methods
        System.out.println("peek(): " + myLinkedList.peek());
        System.out.println("peekFirst(): " + myLinkedList.peekFirst());
        System.out.println("peekLast(): " + myLinkedList.peekLast());

        // Poll methods
        System.out.println("poll(): " + myLinkedList.poll());
        System.out.println("pollFirst(): " + myLinkedList.pollFirst());
        System.out.println("pollLast(): " + myLinkedList.pollLast());

        // Push & Pop
        myLinkedList.push("4");
        System.out.println("After push(): " + myLinkedList);
        System.out.println("pop(): " + myLinkedList.pop());

        // Remove methods
        myLinkedList.remove();
        myLinkedList.remove("100");
        myLinkedList.removeFirst();
        myLinkedList.removeFirstOccurrence("50");
        myLinkedList.removeLast();
        myLinkedList.removeLastOccurrence("300");

        System.out.println("After remove methods: " + myLinkedList);

        // set()
        if (myLinkedList.size() > 1) {
            myLinkedList.set(1, "79");
        }

        System.out.println("After set(): " + myLinkedList);

        // Other methods
        System.out.println("Size: " + myLinkedList.size());
        System.out.println("Spliterator: " + myLinkedList.spliterator());

        Object[] arr = myLinkedList.toArray();
        System.out.println("Array length: " + arr.length);

        System.out.println("toString(): " + myLinkedList);

        // Clear at the end
        myLinkedList.clear();
        System.out.println("After clear(): " + myLinkedList);
    }
}