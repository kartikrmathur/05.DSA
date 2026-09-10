package Recursion;


// check the given number is sorted or not;
// array 
// index 
// and range


public class issorted {

    public static boolean check(int array[], int i) {

        if(i==array.length-1){
            return true;
        }


        if(array[i] >array[i+1]){
            return false;
        }
        
        return check(array, i+1);


    }
    public static void main(String[] args) {
        int array[]= {1,2,3,4,5,6,7};
        System.out.println(check(array, 5));
    }
}
