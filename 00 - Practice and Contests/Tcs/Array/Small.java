package Tcs.Array;

// in this i have to find the smalle and 
// second amlles emenet from the java

// one arry and had to reverse travelles tgis 

public class Small {


    public static void Smallnum(int arr[]){

        if(arr.length < 2){
            System.out.println("Invalid Input");
            return;
        }   

        int smallest = Integer.MAX_VALUE;
        int secondsmallest = Integer.MAX_VALUE;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < smallest){
                secondsmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] < secondsmallest && arr[i] != smallest){
                secondsmallest = arr[i];
            }
        }
        System.out.println(smallest + " " + secondsmallest);
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 5, 2};
        Smallnum(arr);
    }
}


// i have to add this 
// 1 - type  - void 
// 2 - start the loops 1 base
 