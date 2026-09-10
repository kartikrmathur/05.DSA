package QuestionsOnTwoPointer;import java.util.Scanner;

class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(arr[l])) { // Note 1, 2
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(arr[r])) {
                r--;
            }
            // ignore case
            if (Character.toLowerCase(arr[l]) != Character.toLowerCase(arr[r])) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        boolean res = isPalindrome(s);
        System.out.println(res);
    }
}
