public class Main{
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
        System.out.println("Node at 2: " + list.get(2).value);

        System.out.println("\n=== set index 2 to 99 ===");
        list.set(2, 99);
        list.print();

        System.out.println("\n=== removeFirst ===");
        System.out.println("Removed: " + list.removeFirst().value);
        list.print();

        System.out.println("\n=== removeLast ===");
        System.out.println("Removed: " + list.removeLast().value);
        list.print();

        System.out.println("\n=== remove at index 1 ===");
        System.out.println("Removed: " + list.remove(1).value);
        list.print();

        System.out.println("\n=== reverse ===");
        list.reverse();
        list.print();

        list.getHead();
        list.getTail();
        list.getLength();
    }
}