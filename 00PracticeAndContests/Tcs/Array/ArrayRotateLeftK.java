// Problem Statement
// Rotate an array left by K positions.

// Example
// Input:// arr = {1, 2, 3, 4, 5}, K = 2
// Output:// Rotated Array: {3, 4, 5, 1, 2}

// Approach
// Rotate left by K times.
// Shift elements to the left and move the first K elements to the end.
// Real-World Example
// A queue at a ticket counter where people move forward, and the first in line moves to the back.



// Approach :- we have used the two 
// element here 1 - n for the arrays legth 2 - k for the k %n 3 - 2 loops 4 - temp array k 
// fist loop goes for the arrya s length
// second loop goes for the n-1 times
// Source code is decompiled from a .class file using FernFlower decompiler.
// Type :-int 
// loop 1:- 0 t0 k
// loop 2 :-0 to n -1

package Tcs.Array;


public class ArrayRotateLeftK {

 public static void leftRotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // Handle if K > n

        // Rotate K times
        for (int i = 0; i < k; i++) {
            int temp = arr[0]; // Store first element
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1]; // Shift left
            }
            arr[n - 1] = temp; // Move first element to end
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
       leftRotate(arr, k);
        System.out.print("Rotated Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}

// so do this wepass the two args arry and another is ke 
// so in this you first have to pas int n lenghth 
// another is k which k%n and two loop
// one is 0 to arry.length 
// store elem in the k 
// another is go for the 0 to n-1
// store in temp int j = j +1 // shift the stuff in the left
// move n-1 into end 


// need k 
// left to right
// temp ariable first 0
// last arr[n-1] = temp