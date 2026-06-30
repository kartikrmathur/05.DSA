package Tcs.Array;

// here the givn string and the array i have to rotate

import java.util.Scanner;

// so its can be benifitials
// i will use the reverse method to reverse the array


public class Reverse {

    public static void reverseArray(int arr[]){
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }


    }
    public static void main(String[] args) {
        System.out.println("Enetr your array");
        // Scanner Sc = new Scanner(System.in);
        // int arr[] = Sc.nextInt();
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        reverseArray(arr);
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}

// add the user input here wow