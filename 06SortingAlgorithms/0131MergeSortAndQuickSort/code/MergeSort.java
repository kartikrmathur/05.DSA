// REFERENCE ONLY — see the note in 0120's Reference_ivanzykov_LinkedList.java for how to use this.
// Source: https://github.com/ivan-zykov/udemy-dsa-barrett
// File: src/main/java/net/ivanzykov/algorithms/mergesort/MergeSort.java
// Fetched 2026-06-20.
//
// HEADS UP — this file has a real bug, left in deliberately rather than silently fixed, because
// spotting it is good practice: in merge(), the second drain loop does
//     combined[index] = array1[j];
// but it should be array2[j] — it's draining array2's leftovers but reading from array1 by mistake.
// With the sample input in main() below it happens not to trigger an
// ArrayIndexOutOfBoundsException, but it can silently produce a wrong sort on other inputs, or
// throw on inputs where array2 is longer than array1. When you cross-check your own merge() against
// this, find that line and explain out loud why it's wrong and what input would expose it — that's
// a better use of this reference than just reading it.

// No package statement here on purpose — this file isn't nested under matching package folders
// in your project.

import java.util.Arrays;

public class MergeSort {

    public static int[] merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                i++;
            } else {
                combined[index] = array2[j];
                j++;
            }
            index++;
        }
        while (i < array1.length) {
            combined[index] = array1[i];
            index++;
            i++;
        }
        while (j < array2.length) {
            combined[index] = array1[j]; // BUG: should be array2[j] — see header note above
            j++;
            index++;
        }
        return combined;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static void main(String[] args) {

        int[] originalArray = {3,1,4,2};

        int [] sortedArray = mergeSort(originalArray);

        System.out.println( "\nOriginal Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );

        /*
            EXPECTED OUTPUT:
            ----------------
            Original Array: [3, 1, 4, 2]

            Sorted Array: [1, 2, 3, 4]

         */

    }
}
