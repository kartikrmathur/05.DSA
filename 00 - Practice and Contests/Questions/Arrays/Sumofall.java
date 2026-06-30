public class Sumofall{

    public static int sum(int[] num){
        int sumof = 0;
        for (int i = 1; i < num.length; i++) {
            sumof += num[i];
        }
        return sumof;
    }
   public static void main(String[] args) {
    int num[] = {1,2,3,5,6,7,8};
    int total = sum(num);
    System.out.println(total);
   }
}