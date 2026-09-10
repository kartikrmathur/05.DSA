import java.util.Scanner;

public class MathsConcepts{

    public static void main(String[] args) {
//        DisplayDigitsOfNumber();
//        CountDigitsOfNumber();
//        isArmStrong();
//        reverseOfNumber();
//        isPalindrome();
    }

    private static void isPalindrome() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = scan.nextInt();
        int m = n;
        int reverse = 0;
        int r;
        while(n > 0){
            r = n%10;
            reverse = reverse * 10 + r;
            n = n/10;
        }
        if(reverse == m){
            System.out.println("isPalindrome");

        }else{
            System.out.println("!isPalindrome");
        }

    }

    private static void reverseOfNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = scan.nextInt();
        int reverse = 0;
        int r;
        while(n > 0){
            r = n%10;
            reverse = reverse * 10 + r;
            n = n/10;
        }
        System.out.println("reverse:- "+reverse);
    }

    private static void isArmStrong() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = scan.nextInt();
        int m = n;
        int sum = 0 ;
        int r ;
        while(n>0) {
            r = n % 10;
            n = n / 10;
            sum = sum + r * r * r;
        }
            if(sum == m) {
                System.out.println("isArmStrong");
            }else {
                System.out.println("!ArmStrong");
            }
    }


    private static void CountDigitsOfNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = scan.nextInt();
        int count = 0 ;
        while(n>0){
            n=n/10;
            count++;
        }
        System.out.println("Total Count Digits :-  "+count);
    }

    private static void DisplayDigitsOfNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        int n = scan.nextInt();
        int r ;
        while(n>0){
            r = n%10;
            n=n/10;
            System.out.println(r);
        }
    }
}