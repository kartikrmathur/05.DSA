public class Bionomial {

    
    public static int factorial(int n){
        int f = 1;
        for(int i = 1; i<=n ; i++){
            f = f*i;
        }
        return f;
    }

    public static int bionomial(int n , int r){
        int nf = factorial(n);
        int rf = factorial(r);
        int nmrf = factorial(n-r);

        int bio = nf / (rf*nmrf);

        return bio;
    }
    public static void main(String[] args) {
        System.out.println(bionomial(3, 2));
    }
}



// so basicall first in factorial function
// then bionomial function which includes the para
// in main function we just call what we want
// simple