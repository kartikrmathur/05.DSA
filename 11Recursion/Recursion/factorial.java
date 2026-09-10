package Recursion;


//print the factorial numbers in java


public class factorial {


    public static int fact(int n ) {

        if(n==1){
            return n ;
        }
        
        int fnm1 = fact(n-1);
        int main = n * fnm1;
        return main;
    }
    public static void main(String[] args) {
        System.out.println(fact(4));
        
    }
}


// logic
// the logic of the factorial is n into n-1 
// untill the given number is there
// firstly goes to numbr and add recursive approach to multiplication in all 
// until aall the call stack