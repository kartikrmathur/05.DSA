package Questions.Arrays;

public class removeDuplicate {

    public static int removeit(int[] nums){
        if (nums.length ==0) {
            return 0;
        }

        int counter = 1;

        for(int i=1; i<nums.length ; i++){
            if (nums[i] != nums[i-1]) {
                nums[counter] = nums[i];
                counter ++;
            }
        }
        return counter;

    }


    public static void main(String[] args) {
        int[] nums = {12,34,1,1,2,3,4,5,6,6,7,12,};
         
        int clearedduplicate = removeit(nums);
        System.out.println(clearedduplicate);

        for (int i = 0; i < clearedduplicate; i++) {
            System.out.println(nums[i]);
        }

    }
}
