package Tcs.Array;

//i have to right rotate the array like
// input - 1 ,2 ,3 4,5 nd k = 2
// output - 4,5,1,2,3


// inthis it can be done by the array k input
// and first 2 loop
// first loppp make elamet to the right
// in another loop go last elemnst to left element 
// arr[j] = arr[j -1 ];

public class RightRotateK {

    // create themedthod 

    public static void rightRotate(int arr[] , int k ) {
        int n = arr.length;
        k = k % n; // Handle if K > n

        // this hereis th efirst loo[]
        for(int i = 0 ; i < k ; i++){
            int temp = arr[n-1]; // store last element
            for(int j = n-1 ; j > 0 ; j --){
                arr[j] = arr[j-1];
            }
            arr[0] = temp;
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int k = 2;
        rightRotate(arr, k);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i] + " ");
        }

    }    
}


 // for the right roatation you neded one array
 // and the elemenet ehere you have to chnage
 // 2 loop first make last elemenst 
 // second right to 0 in that push to j 
 // and arr[0] = temp;
// 4 5 1 2 3
// its es

// need k
// right to left
// temp ariable last n-1
// first arr[0] = temp