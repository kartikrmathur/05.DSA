import java.util.Scanner;

public class InputFuc {
// scope one
    // public static void sum(){
    //     Scanner sc = new Scanner(System.in);
    //     int a = sc.nextInt();
    //     int b = sc.nextInt();
    //     int sum = a + b;
    //     System.out.println("sum is :" + sum);

    // }
    // public static void main(String[] args) {
    //     System.out.println(" start the function");
    //     sum();
    // }

    // Scope 2

    public static void Cals(int a , int b){
        int sum = a + b;
         System.out.println("sum is :" + sum);
    }
     public static void main(String[] args) {
         System.out.println(" start the function");
         Scanner sc = new Scanner(System.in);
         int a = sc.nextInt();
        int b = sc.nextInt();
       Cals(a,b);
     }
}




// basically in this we can pass input
// on the body
// Scope on is simple function
// scope 2 has inner parameter which can return
// and in main function we take input and just call
// the function         