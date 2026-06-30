package Tcs.Array;

// Input:arr1 = {1, 2, 3, 4, 5}, arr2 = {2, 4, 5}
// Output:Array2 is a subset of Array1

public class Subset {
    

    public static boolean isSunset(int arr1[], int arr2[]){
     for(int num : arr2){
        boolean found = false;
        for(int element : arr1){
            if(num == element){
                found = true;
                break;
            }

        }
        if(!found){
            return false;
        }
     }
        return true;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {2, 4, 5};
        System.out.println(isSunset(arr1, arr2)? "Array2 is a subset of Array1" : "Array2 is NOT a subset of Array1");
    }
}


//  i can made this also
// i have just need  that gne o nly thinf si sthat the and
// need two arravy
// two loop
// firt fpor the array 2 num loop
// boolean false
// second loop is for boolean array 1
// if and return 

// if(!foundd) == return false ;

// return true;  // return true    