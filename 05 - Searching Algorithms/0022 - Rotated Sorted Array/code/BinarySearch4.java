import java.util.List;

//leetcode 33. Search in Rotated Sorted Array
class RotatedSearch1 {
    public int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int ans=-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return ans;
    }
}

// leetcode 81. Search in rotated sorted array 2
class RotatedSearch2 {
    public boolean search(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        boolean ans=false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return true;
            }
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
            }
            else if (arr[start] <= arr[mid]) {
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return ans;
    }
}

// leetcode 153. Find Minimum in Rotated Sorted Array
class RotatedSearch3 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n-1;
        int minElement = Integer.MAX_VALUE;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[start]<=nums[mid]){
                minElement = Math.min(minElement,nums[start]);
                start = mid+1;
            }else{
                minElement = Math.min(minElement,nums[mid]);
                end = mid-1;
            }
        }
        return minElement;
    }
}

// gfg find Kth Rotation
class RotatedSearch4 {
    public int findKRotation(List<Integer> arr) {
        int n = arr.size();
        int start = 0;
        int end = n-1;
        int minElement = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr.get(start)<=arr.get(mid)){
                if(arr.get(start) < minElement){
                    minElement = arr.get(start);
                    minIndex = start;
                }
                start = mid+1;
            }else{
                if(arr.get(mid) < minElement){
                    minElement = arr.get(mid);
                    minIndex = mid;
                }
                end = mid-1;
            }
        }
        return minIndex;
    }
}

// 154. Find Minimum in Rotated Sorted Array II
class RotatedSearch5 {
    public int findMin(int[] nums) {
        int index = minElement(nums);
        return nums[index];
    }
    static int minElement(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while (start < end){
            int mid = start + (end-start)/2;
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                start++;
                end--;
            }
            else if(mid>0 && arr[mid]<arr[mid-1]){
                return mid;
            }
            else if(arr[end]>=arr[mid]){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return start;
    }
}
