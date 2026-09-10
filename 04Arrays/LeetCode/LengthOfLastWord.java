import java.util.Scanner;

public class LengthOfLastWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String n = scan.nextLine();
        System.out.println(lengthOfLastWord(n));
    }

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;

        // Step 1: skip any trailing spaces
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                end = i;
                break;
            }
        }

        // Step 2: count characters of the last word
        int count = 0;
        for (int i = end; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }

        return count;
    }
//
//    public static int lengthOfLastWord(String s) {
//
//        int lengthOfLastWord = 0;
//        int i = s.length() - 1;
//
//        while (i >= 0 && s.charAt(i) == ' ') {
//            i--;
//        }
//
//        // count characters of the last word
//        while (i >= 0 && s.charAt(i) != ' ') {
//            lengthOfLastWord++;
//            i--;
//        }
//        return lengthOfLastWord;
//    }
}