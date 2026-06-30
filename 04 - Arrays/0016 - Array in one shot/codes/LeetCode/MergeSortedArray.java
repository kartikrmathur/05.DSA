package LeetCode;

public class MergeSortedArray{
    public static void main(String[] args) {
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1index = m-1;
        int nums2index = n-1;
        int mergePosition = m+n-1;

        while(nums1index >= 0 && nums2index>=0){
            if(nums1[nums1index]>nums2[nums2index]){
                nums1[mergePosition] = nums1[nums1index];
                nums1index--;
            }else{
                nums1[mergePosition] = nums2[nums2index];
                nums2index--;
            }
            mergePosition--;
        }
        while(nums2index>=0){
            nums1[mergePosition] = nums2[nums2index];
            nums2index--;
            mergePosition--;
        }
    }
}