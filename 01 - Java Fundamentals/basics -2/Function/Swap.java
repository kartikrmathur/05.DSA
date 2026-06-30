public class Swap {

    public static void swap(int a , int b){
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

    };
    public static void main(String[] args) {
       int a = 10;
       int b = 20;
        swap(a, b);
        swap(40, 20);
    }
}

// i write the sout code in main
// function it makes error cause
// it value has been change after function execution

// not fix arguments also used function instead or
// para meter if we dwclare para in funtion but we want to add arguments 
// its also usefull.