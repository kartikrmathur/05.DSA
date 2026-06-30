package Tcs.Array;

// in this i gave you one array and have to

import java.util.Arrays;

// teturns the mean and median of that array

// means : - sum of all by lenghth
// median is center most 

public class MenMed {


    public static double mean(int arr[]){
        int sum = 0;

         for (int num : arr) {
            sum += num;
        }
        return (double)sum/arr.length;

    }

    public static double median(int arr[]){
        Arrays.sort(arr);
        int  n = arr.length;
       if (n % 2 == 0) {
            return (arr[n / 2 - 1] + arr[n / 2]) / 2.0;
        } else {
            return arr[n / 2];
        }
    
    }
    
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println("Mean of the array is : " + mean(arr));
        System.out.println("Median of the array is : " + median(arr));
    }
}


// this is one of the easy one okkey harsh
// i have to just remenber the past ones
// for the realizations