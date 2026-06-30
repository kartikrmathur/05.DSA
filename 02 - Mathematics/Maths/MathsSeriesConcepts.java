import java.util.Scanner;


public class MathsSeriesConcepts {

    public static void main(String[] args) {
//        aP();
//        gP();
        fibonaciSeries();
    }

    private static void fibonaciSeries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("proagram to Fibonnaci Series");
        System.out.println("Enter number of Terms");
        int n = sc.nextInt();
        int a = 0, b = 1, c;
        System.out.print(a+","+b+",");
        for(int i=0;i<n-2;i++){
            c=a+b;
            System.out.print(c+",");
            a=b;
            b=c;
        }
    }

    private static void gP() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a, d and n");
        int a = sc.nextInt();
        int r = sc.nextInt();
        int n = sc.nextInt();

        int term = a;
        for(int i=0;i<n;i++){
            System.out.print(term+",");
            term=term*r;
        }
    }

    private static void aP() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a, d and n");
        int a = sc.nextInt();
        int d = sc.nextInt();
        int n = sc.nextInt();

        int term = a;
        for(int i=0;i<n;i++){
            System.out.print(term+",");
            term=term+d;
        }

    }
}