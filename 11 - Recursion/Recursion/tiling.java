package Recursion;


// imp tiling pronlem in java


public class tiling {


    // gives you 2x1 boeard tiles which can fit ni 2xn size of the board give me number of ways to find the problem for that

    // there two choices vericlly and horizonatally



    public static  int tp(int n) {
        if(n==0 || n==1){
            return 1;
        }

        // for verical tiles
        int vrt = tp(n-1);

        // for horizontally 
        int hrz = tp(n-2);

        return vrt+hrz;
    }




    // friend pairways problem 
    // firnds can remain single or pair with the other friend

    public static  int fp(int n){
        if(n==1 || n==2){
            return n;
        }



        // for single firend

        int fnm1 = fp(n-1);


        // for pair

        int fnm2 = fp(n-2);

        int pairways = (n-1) * fnm2;

        return fnm1 + pairways;
    }




    public static void main(String[] args) {
        System.out.println(tp(3));
    }
}



