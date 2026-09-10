package Tcs.Array;
// Given an array of integers, find the first element that does not repeat.

// Example
// Input:
// arr = {4, 5, 1, 2, 0, 4, 5, 2}

// Output:
// 1

// Approach
// Iterate through the array.
// For each element, check how many times it appears in the array.
// Return the first element that appears only once.


// the question is i have givenn an array in that i have to finf the 
// firsr element who is repeat so i need the
// n element , 2 loops first cover all and inside check for all thing
// if gets so it can repelats the elment it self its easy not hard 


// 1 - n , 2 - loops 3 m if it gets so it can be repeated so it can be

// Type :-int 
// loop 1:- 0 t0 n 
// loop 2 :-0 to n 
public class ArrayFirstNonRepeatEle {
   

public static int findFirstNonRepeating(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean isRepeated = false;
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j] && i != j) {
                    isRepeated = true;
                    break;
                }
            }
            if (!isRepeated) {
                return arr[i];
            }
        }
        return -1; // No unique element found
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 0, 4, 5, 2};
        System.out.println("First Non-Repeating Element: " + findFirstNonRepeating(arr));
    }
}

// Time Complexity: O(n^2)

