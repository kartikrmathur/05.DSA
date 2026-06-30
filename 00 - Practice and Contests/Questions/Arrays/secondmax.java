package Questions.Arrays;
// to find second max element in the program

public class secondmax {

    public static int secondmax(int[] nums){

        if (nums.length <2) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        int secondmax = Integer.MIN_VALUE;
      
        for(int i =0; i<nums.length; i++){
           if (nums[i] > max) {
            secondmax = max;
            max = nums[i];
           }else if(nums[i] > secondmax && nums[i] != max){
                    secondmax = nums[i];
           }
        }
        return secondmax;
    }




    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};

        int secondmaxE = secondmax(nums);
        System.out.println(secondmaxE);


    }
}
