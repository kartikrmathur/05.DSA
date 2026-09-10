import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyArray {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            userInput();
//            arraysimple();
//           int[][] my2dArray = readJagged2dArray(sc, 3, 4);
//            print2dArray(my2dArray);
            // Uncomment to try other operations:
            // insert2dArray(my2dArray, 0, 0, 5);
            // print2dArray(my2dArray);
            // delete2dArray(my2dArray, 0, 0);
            // print2dArray(my2dArray);
            // update2dArray(my2dArray, 0, 0, 6);
            // print2dArray(my2dArray);
            // Other demos:
            // searchingSecondLargestElementFromArray();
            // searchingAnElementFromArray(sc);
            // sumOfAllElementOfArray();
            // sumOfAllElementOfArrayUsingForEach();
            // arrayBasics();
            // arrayAsList();
            // twoDArray();
        }
    }

    public static void arraysimple() {
//      int[] marks = new int[3];
        int marks[] = new int[3];
        marks[0] = 97;
        marks[1] = 97;
        marks[2] = 97;
        for(int i =0; i<3;i++){
            System.out.println(marks[i]);
        }
    }

    public static void arrayDefine() {
        int marks[] = {97,98,99};
    }


    public static void userInput() {
     Scanner sc = new Scanner(System.in);
     int size = sc.nextInt();
     int numbers[] = new int[size];
        for(int i=0; i<size; i++){
            numbers[i] = sc.nextInt();
        }
     for(int i=0;i<size;i++){
        System.out.println(numbers[i]);
     }
    }

    /**
     * Reads a jagged 2D array from the console: {@code rows} rows, where row 0 has
     * {@code firstRowSize} columns and each following row has one column fewer.
     */
    public static int[][] readJagged2dArray(Scanner sc, int rows, int firstRowSize) {
        int[][] arr = new int[rows][];
        int colSize = firstRowSize;

        for (int i = 0; i < rows; i++) {
            arr[i] = new int[colSize];
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Enter element [" + i + "][" + j + "]: ");
                arr[i][j] = sc.nextInt();
            }
            colSize--;
        }
        return arr;
    }

    // ---- 1D array core operations ----

    public static void update(int[] arr, int pos, int element) {
        if (isOutOfBounds(pos, arr.length)) {
            System.out.println("Wrong position");
            return;
        }
        arr[pos] = element;
    }

    public static void delete(int[] arr, int pos) {
        if (isOutOfBounds(pos, arr.length)) {
            System.out.println("Wrong position");
            return;
        }
        // Shift subsequent elements one step towards the start.
        for (int i = pos; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = 0;
    }

    public static void insert(int[] arr, int pos, int element) {
        if (isOutOfBounds(pos, arr.length)) {
            System.out.println("Wrong position");
            return;
        }
        // Shift elements one step towards the end to make room (last element is dropped).
        for (int i = arr.length - 2; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = element;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    private static boolean isOutOfBounds(int pos, int size) {
        return pos < 0 || pos > size - 1;
    }

    // ---- 2D array core operations ----

    public static void print2dArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("For " + i + " index");
            printArray(arr[i]);
        }
    }

    public static void insert2dArray(int[][] arr, int pos1, int pos2, int element) {
        if (isOutOfBounds(pos1, arr.length)) {
            System.out.println("Wrong position");
            return;
        }
        insert(arr[pos1], pos2, element);
    }

    public static void delete2dArray(int[][] arr, int pos1, int pos2) {
        if (isOutOfBounds(pos1, arr.length)) {
            System.out.println("Wrong position");
            return;
        }
        delete(arr[pos1], pos2);
    }

    public static void update2dArray(int[][] arr, int pos1, int pos2, int element) {
        if (isOutOfBounds(pos1, arr.length)) {
            System.out.println("Wrong position");
            return;
        }
        if (isOutOfBounds(pos2, arr[pos1].length)) {
            System.out.println("Wrong position");
            return;
        }
        arr[pos1][pos2] = element;
    }

    // ---- Searching / aggregation demos ----

    public static void searchingSecondLargestElementFromArray() {
        int[] a = {3, 9, 7, 8, 12, 6, 15, 5, 4, 10};
        int max1 = a[0];
        int max2 = a[0];

        for (int x : a) {
            if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }
        }
        System.out.println("Second largest is " + max2);
    }

    public static void searchingAnElementFromArray(Scanner sc) {
        int[] a = {3, 9, 7, 8, 12, 6, 15, 5, 4, 10};

        System.out.println("Enter a key: ");
        int key = sc.nextInt();

        for (int i = 0; i < a.length; i++) {
            if (key == a[i]) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Not found");
    }

    public static void sumOfAllElementOfArray() {
        int[] a = {3, 9, 7, 8, 12, 6, 15, 5, 4, 10};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        System.out.println("Sum is " + sum);
    }

    public static void sumOfAllElementOfArrayUsingForEach() {
        int[] a = {3, 9, 7, 8, 12, 6, 15, 5, 4, 10};
        int sum = 0;
        for (int x : a) {
            sum += x;
        }
        System.out.println("Sum is " + sum);
    }

    // ---- Array basics / reference demos ----

    private static void arrayBasics() {
        int[] array = new int[5];
        array[0] = 10;
        System.out.println(Arrays.toString(array)); // [10, 0, 0, 0, 0]

        int[] b = {2, 4, 6, 8, 10};
        b[2] = 15;

        // Post-increments each element while printing (each value ends up +1).
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]++ + " ");
        }
        System.out.println();

        // Enhanced for-loop: cleaner, but forward-only and read-only (no index access).
        for (int x : b) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void arrayAsList() {
        List<Integer> list = new ArrayList<>();
        list.add(10);                      // [10]
        list.add(0, 10);                   // [10, 10]
        System.out.println(list.size());   // 2
        list.remove(0);                    // remove by INDEX  -> [10]
        list.remove(Integer.valueOf(10));  // remove by VALUE  -> []
        System.out.println(list);          // []
    }

    public static void twoDArray() {
        int[][] arr = new int[3][4];       // 3 rows, 4 cols, all 0
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}}; // literal init

        int[][] jagged = new int[3][];
        jagged[0] = new int[2];
        jagged[1] = new int[5];

        // Traversal (use arr[i].length, not arr[0].length, so this stays safe for jagged arrays too)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // arr[i][j]
            }
        }
        for (int[] row : arr) {
            for (int val : row) {
                // val
            }
        }

        System.out.println(Arrays.deepToString(arr));
        // Arrays.toString(arr) would print garbage hashcodes per row - same trap as with 1D arrays.

        // Copying
        int[][] shallow = arr.clone();     // rows are still shared: mutating shallow[0][0] mutates arr too
        int[][] deep = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new); // true deep copy
    }
}