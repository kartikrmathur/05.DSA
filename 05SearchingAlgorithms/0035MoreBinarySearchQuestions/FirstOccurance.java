package QuestionOnBinarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FirstOccurance {
    public static int findFirstOccurrence(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size() -1;
        int occurance = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr.get(mid) == target){
                occurance = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return occurance;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        List<Integer> arr = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        int target = Integer.parseInt(scanner.nextLine());
        scanner.close();
        int res = findFirstOccurrence(arr, target);
        System.out.println(res);
    }
}
