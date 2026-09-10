package QuestionOnBinarySearch;

/*
* Given an array of integers nums which is sorted in ascending order,
*  and an integer target, write a function to search target in nums.
*  If target exists, then return its index. Otherwise, return -1.
* You must write an algorithm with O(log n) runtime complexity.
* */
public class BinarySearch {

    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length -1;
        int occurance = -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(arr[mid] == target){
                occurance = mid;
                right = mid - 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return occurance;
    }

}
