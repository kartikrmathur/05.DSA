package Recursion;


// find the first occurance in the given array and return that index

// main empty array
//index element
// range of n

public class fistoc {
    public static int oc(int n ,int arr[], int i) {


        if(i==arr.length){
            return -1;
        }

        if(arr[i] == n){
            return i;
        }

        return oc(n, arr, i+1);
        
    }

     public static int loc(int n ,int arr[], int i) {


        if(i==arr.length){
            return -1;
        }

      int isfound =  loc(n, arr, i);
      if(isfound == -1 && arr[i] ==n){
        return i;
      }

      return isfound;
        
    }
    public static void main(String[] args) {

        int arr[] = {1,2,4,5,6,7,8};
        System.out.println(oc(4, arr, 1));
        System.out.println(loc(4, arr, 1));
    }
}



//logic for the last occurance

