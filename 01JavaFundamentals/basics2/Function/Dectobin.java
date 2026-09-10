public class Dectobin {

    public static void Bin(int n) {
        int pow = 0;
        int myNum = n;
        int binNum = 0;

        while (n>0) {
            int rem = n%2;
            binNum = binNum + (rem * (int)Math.pow(10, pow));
            pow++;
            n = n/2;
        }
        System.out.println("binary form of" + myNum + "=" + binNum);
    }
    public static void main(String[] args) {
        Bin(100);
    }
}
