import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = Integer.parseInt(scan.nextLine());

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scan.nextLine();
        }

        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i=1; i<strs.length; i++){
            while(strs[i].indexOf(prefix)!= 0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}