public class Sr {

    public static int search(int arr[], int tar , int si , int ei){

        //base case
        if (si>ei) {
            return -1;
        }

        // work

        int mid = si + (ei-si)/2;

        if(arr[mid] == tar){
            return mid;
        }


        // mid on l1

        if(arr[si] <= arr[mid]){
                //case A
                if (arr[si] <= tar && tar <= arr[mid]) {
                    return search(arr, tar, si, mid-1);
                }else{
                   // case B
                  return  search(arr, tar, mid+1, ei) ;
                }
        }

        //mid on l2

        else {
            // case c
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid+1, ei);
            }else {
                //case D

                return search(arr, tar, si, mid-1);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target =0;
       int tardx = search(arr, target, 0, arr.length-1);
       System.out.println(tardx);
    }
}
