// Rebuild scaffold — Merge Sort and Quick Sort, the two classic sorts your existing notes were missing.

public class Sorts {

    public static int[] mergeSort(int[] arr) {
        // TODO: base case (length <= 1), split into left/right halves,
        // recursively mergeSort each half, then merge() them
        return arr;
    }

    private static int[] merge(int[] left, int[] right) {
        // TODO: classic two-pointer merge of two sorted arrays — see your existing
        // "Find Kth element of Two Sorted Arrays" (0029) intuition, same merging idea
        return null;
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        // TODO: base case (lo >= hi), pick pivot (e.g. last element),
        // partition around it, recurse on both sides
        if (lo < hi) {
            int pivotIndex = partition(arr, lo, hi);
            quickSort(arr, lo, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        // TODO: Lomuto or Hoare partition scheme — pick one, know it cold either way
        return lo;
    }
}
