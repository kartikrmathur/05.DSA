package Recursion;


// print numbers in n to 1 like decrement in java


public class dec {


     public static void dec(int n ) {

        if (n==1){
            System.out.println(n);
            return ;
        }

         System.out.println(n);
         dec(n-1);
     }
    public static void main(String[] args) {
        dec(10);
    }
}


// logic 
// n number
// n-1 print and recus
// base case