package Questions.Strings;

public class Reverse {

    public static String reverse(String str){
        char[] charArray = str.toCharArray();
        int left = 0;
        int right =str.length() -1;


        while (left<right) { 
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
    public static void main(String[] args) {
        String str = "harsh";
        String result = reverse(str);
        System.out.println(result);
    }
}
