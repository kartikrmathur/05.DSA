import java.util.Scanner;

public class inputTake {
    public static void main(String[] args) {
        System.out.println("gave us some random things");
         Scanner sc = new Scanner(System.in);
        //  String name = sc.next();
        //  System.out.println(name);

            String name = sc.nextLine();
            System.out.println(name);
            
            int number = sc.nextInt();
            System.out.println(number);

            float price = sc.nextFloat();
            System.out.println(price);
    }
}
