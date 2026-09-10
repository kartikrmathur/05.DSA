public class max {
    // Method to find the maximum element in the array
    public static int findMax(int[] nums) {
        int max = nums[0]; // Initialize max with the first element

        // Loop through the array starting from the second element
        for (int i = 1; i < nums.length; i++) { // Change the loop condition to i < nums.length
            if (nums[i] > max) {
                max = nums[i]; // Update max if the current element is greater
            }
        }
        return max; // Return the maximum value found
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5}; // Example array

        int maxElement = findMax(nums); // Find the maximum element in the array
        System.out.println(maxElement); // Print the maximum element
    }
}
