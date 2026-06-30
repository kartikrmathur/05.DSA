public class Average {

    public static int avg(int num[]){
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum +=num[i];
        }
        int averageg = sum /num.length;
        return averageg;
    }

    public static void main(String[] args) {
        int num[] = {10,10,10};
        System.out.println(avg(num));

    }
}
