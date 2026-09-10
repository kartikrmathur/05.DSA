public class Product {

    // product of java
    public static int product(int a , int b){
        return a*b;
    }

    // devision of java
    public static int devision(int a , int b){
        return a/b;
    }
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int value = product(a, b);
        int none = product(50 , 10);
        int devision = devision(5000, 100);
        System.out.println(devision);
        System.out.println(value);
        System.out.println(none);
    }

    
}


/// so basically in the void it cant return valur you just 
//add the numbers in it and it gaves the value
// IN int,float it return value which can you use in the
//next main function