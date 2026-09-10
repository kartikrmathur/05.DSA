package Recursion;


// print the fibonaci number for the given range of the numbers
// it depends on the lats two elements
// 011235813

// so fn = fn-1 and fn-2
public class fibonaci {
  
    public static int fino(int n) {
        

        if(n==0 || n==1){
            return 1;
        }

        int fnm1 = fino(n-1);
        int fnm2 = fino(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }

    public static void main(String[] args) {
        System.out.println(fino(5));
    }

}
