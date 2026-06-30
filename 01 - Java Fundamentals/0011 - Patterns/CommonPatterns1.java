
public class CommonPatterns1 {

    public static void main(String[] args) {
//        pattern1();
//        pattern2();
//        starpattern1();
//        pattern3();
        starpattern2();
    }

    private static void pattern1() {
        for(int i =1; i<=5 ; i++){
            for(int j =1; j<=i ; j++){
                System.out.print(j+" ");
            }
            System.out.println("");
        }
    }

    private static void pattern2() {
        int count = 0;
        for(int i =1; i<=5 ; i++){
            for(int j =1; j<=i ; j++){
                count++;
                System.out.print(count+" ");
            }
            System.out.println("");
        }
    }

    private static void starpattern1() {
        for(int i =1; i<=5 ; i++){
            for(int j =1; j<=i ; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    private static void pattern3() {
        for(int i =1; i<=5 ; i++){
            for(int j =1; j<=5-i+1; j++){
                System.out.print(j+ " ");
            }
            System.out.println("");
        }
    }

    private static void starpattern2() {
        for(int i =1; i<=5 ; i++){
            for(int j =1; j<=5-i+1; j++){
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

}