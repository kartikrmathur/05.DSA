package Tcs.Array;
// i have to find the largest eleent in the java

// okkey bro
//
public class Largest {
    public static void largestIn(int arr[]){
        int max = Integer.MIN_VALUE;
        int secodMax = Integer.MIN_VALUE;
        for(int num : arr){
            if(num > max ){
                secodMax = max;
                max = num;
            }else if(num > secodMax && num != max){
                secodMax = num;
            }

        }
       System.out.println("Largest element is : "+max);
         System.out.println("Second Largest element is : "+secodMax);
  }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        largestIn(arr);
        
       
    }
}
