
public class CommonPatterns {
    public static void main(String[] args) {
//        patterns1();
//        patterns2();
//        patterns3();
//        patterns4();
//        patterns5();
    }

    private static void patterns1() {
        for(int i =0; i<=5 ; i++){
            for(int j =0; j<=5 ; j++){
                System.out.print("("+i+","+j+")");
            }
            System.out.println("");
        }
    }
    private static void patterns2() {
        for(int i =1; i<=5 ; i++){
            for(int j =1; j<=5 ; j++){
                System.out.print(j+" ");
            }
            System.out.println("");
        }
    }

    private static void patterns3() {
        for(int i =1; i<=5 ; i++){
            for(int j =1; j<=5 ; j++){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }

    private static void patterns4() {
        for(int i =1; i<=5 ; i++){
            for(int j =1; j<=5 ; j++){
                System.out.print(i+j+" ");
            }
            System.out.println("");
        }
    }
    private static void patterns5() {
        int count = 0;
        for(int i =1; i<=5 ; i++){
            for(int j =1; j<=5 ; j++){
                count++;
                System.out.format("%02d  ",count);
            }
            System.out.println("");
        }
    }
}
