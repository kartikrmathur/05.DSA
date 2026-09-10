package Recursion;

// increment for n numbers in java

public class inc {

    public static void inc(int n) {
        if(n==0){
            System.out.println(n);
            return;
        }

        inc(n-1);
        System.out.println(n);
    }
    public static void main(String[] args) {
        inc(12);
    }
}


// logic

// firstly incremental value 
// go untill avalue to minus 1 and then print
// reverse the loop
