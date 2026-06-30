import java.util.Scanner;

public class sumAB {
    public static void main(String[] args) {
        Scanner addinput = new Scanner(System.in);
        // its the sum fof ab i know its run time i saw a many errors nut its okey its good practice

        System.out.println("phase 1 is sum");
        // System.out.println("sum of these 2 is" + first+ second);
            System.out.println(" add first num");
        int a = addinput.nextInt();
            System.out.println("add second num");
        int b = addinput.nextInt();
        int sum= a+ b;
        System.out.println(sum);
            System.out.println("this is result");

                System.out.println("its time to start product");

        // now product
         System.out.println(" add first num");
         int h = addinput.nextInt();
          System.out.println(" add second num");
        int s = addinput.nextInt();
        int product= h*s ;
        System.out.println(product);

        // time to do area of circle
        float rad = addinput.nextFloat();
        float area = 3.14f * rad * rad;
        System.out.println(area);
    }
}
