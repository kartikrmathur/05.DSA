package Questions.Arrays;

public class swapArray {

    public static void swapit(int num[]){
        int start = 0;
        int end = num.length-1;

        while (start<end) { 
          int temp = num[start];
          num[start]= num[end];
          num[end]=temp;
          start++;
          end--;
          
        }
       
    }

    public static void main(String[] args) {
        int num[] = {1,2,3,4,5,6,7};
      swapit(num);
       
    }
}
