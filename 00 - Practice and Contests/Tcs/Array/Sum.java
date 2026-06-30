package Tcs.Array;

import java.util.Scanner;

public class Sum {
    public static void sum(int arr[]) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        System.out.println("Sum of array elements is: " + sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt(); // ✅ Corrected to sc.nextInt()

        int arr[] = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // ✅ Reads array elements properly
        }

        sc.close(); // ✅ Close scanner to prevent resource leak

        sum(arr); // ✅ Calls the sum method with the correct array
    }
}
