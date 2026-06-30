import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        searchingSecondLargestElementFromArray();
    }

    public static void searchingSecondLargestElementFromArray() {
        Scanner sc = new Scanner(System.in);
        int A[] = {3,9,7,8,12,6,15,5,4,10};
        int max1,max2;

        max1=max2=A[0];

        for(int i = 0; i < A.length; i++){
            if(A[i]>max1){
                max2=max1;
                max1=A[i];
            }
            else if(A[i]>max2){
                max2=A[i];
            }
        }
        System.out.println("Second Largest is "+max2);
    }
    public static void searchingAnElementFromArray() {
        Scanner sc = new Scanner(System.in);
        int A[] = {3,9,7,8,12,6,15,5,4,10};
        int key ;
        System.out.println("Enter a key ");
        key = sc.nextInt();
        for(int i = 0; i < A.length; i++){
            if(key == A[i]){
                System.out.println("Element Found at Index:- "+i);
                System.exit(0);
            }
        }
        System.out.println("Not found");
    }
    public static void sumOfAllElementofArray() {
        int A[] = {3,9,7,8,12,6,15,5,4,10};
        int sum = 0;
        for(int i = 0; i < A.length; i++){
            sum = sum+A[i];
        }
        System.out.println("Sum is "+sum);
    }

    public static void sumOfAllElementofArrayUsingForEach() {
        int A[] = {3,9,7,8,12,6,15,5,4,10};
        int sum = 0;
        for(int x:A){
            sum = sum+x;
        }
        System.out.println("Sum is "+sum);
    }
    private static void arrayBasics() {
        int[] Array = new int[5];
        Array[0] = 10;   // "add" 10 at index 0
        System.out.println(Arrays.toString(Array));  // [10, 0, 0, 0, 0]

        int A[] = new int[10];
        int B[] = {2,4,6,8,10};
        B[2] = 15;
        int C[] ;
        C = new int[10];

        for(int i = 0; i < B.length; i++){
            System.out.print(B[i]++ +" ");
        }

        System.out.println();
//      More User Programmer Friendly
//      Only in forward direction
        for(int x: B){
            System.out.print(x +" ");
        }
    }

    public static void arrayAsList() {
        List<Integer> list = new ArrayList<>();
        list.add(10);                      // [10]
        list.add(0, 10);                   // [10, 10]
        System.out.println(list.size());   // 2
        list.remove(0);                    // remove by INDEX → [10]
        list.remove(Integer.valueOf(10));  // remove by VALUE → []
        System.out.println(list);          // []
    }
    public static void twoDArray() {
        int[][] arr = new int[3][4];              // 3 rows, 4 cols, all 0
        int[][] arr2 = {{1,2,3},{4,5,6}};         // literal init

        int[][] jagged = new int[3][];
        jagged[0] = new int[2];
        jagged[1] = new int[5];

//        Traversal
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {   // use arr[i].length, not arr[0].length, for jagged safety
                // arr[i][j]
            }
        }
        for (int[] row : arr) {
            for (int val : row) { /* val */ }
        }
//          String
        System.out.println(Arrays.deepToString(arr));   // [[1, 2], [3, 4]]
        // Arrays.toString(arr) gives garbage hashcodes per row — same trap as 1D

//        Copying

        int[][] shallow = arr.clone();                  // rows still shared! mutating shallow[0][0] mutates arr too
        int[][] deep = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);  // true deep copy
    }

}
