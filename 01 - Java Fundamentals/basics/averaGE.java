import java.util.Scanner;

public class averaGE {
    public static void main(String[] args) {
        System.out.println("in this we make average of 3 numbers");
        Scanner sc = new Scanner(System.in);

        // average of 3
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int sum = (a + b + c) / 3;
        System.out.println(sum);


        // side of square
        System.out.println("its time to square");
        int aa = sc.nextInt();
        int summ = (aa*aa);
        System.out.println(summ);


        float pencil = sc.nextFloat();
                float pen = sc.nextFloat();
                        float eraser = sc.nextFloat();
                         float total = (pencil + pen + eraser);
                         System.out.println(total);

                         float newTotal = total + (0.18f * total);
                         System.out.println(newTotal);


    }
}
// simple