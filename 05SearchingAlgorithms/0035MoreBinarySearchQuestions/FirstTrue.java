package QuestionOnBinarySearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FirstTrue {
    public static int findBoundary(List<Boolean> arr) {
        int left = 0;
        int right = arr.size() -1;
        int boundaryIndex = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr.get(mid)){
                boundaryIndex = mid;
                right = mid - 1;
            }else{
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
        List<Boolean> arr = splitWords(scanner.nextLine()).stream().map(v -> v.equals("true")).collect(Collectors.toList());
        scanner.close();
        int res = findBoundary(arr);
        System.out.println(res);
    }
}
