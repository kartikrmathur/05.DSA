package QuestionOnBinarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class ThePeakOfAMountainArray {
    public static int peakOfMountainArray(List<Integer> arr) {
        int arraylength = arr.size();
        int left = 0;
        int right = arraylength - 1;
        int boundaryIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == arraylength - 1 || arr.get(mid) > arr.get(mid + 1)) {
                boundaryIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return boundaryIndex;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = peakOfMountainArray(arr);
        System.out.println(res);
    }
}
