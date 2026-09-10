public class RemoveDuplicates {

    // Helper function to remove duplicates
    public static String removeDuplicates(String str, int index, StringBuilder result) {
        // Base case: if we reach the end of the string, return the result
        if (index == str.length()) {
            return result.toString();
        }

        // Current character
        char currentChar = str.charAt(index);

        // Check if the result already contains the current character
        if (result.indexOf(String.valueOf(currentChar)) == -1) {
            // If not present, add it to the result
            result.append(currentChar);
        }

        // Recursive call for the next character
        return removeDuplicates(str, index + 1, result);
    }

    // Main function to initiate the recursion
    public static String removeDuplicates(String str) {
        // Start with an empty result and index 0
        return removeDuplicates(str, 0, new StringBuilder());
    }

    // Testing the function
    public static void main(String[] args) {
        String str = "aabbccddeeff";
        System.out.println("Original: " + str);
        System.out.println("Without duplicates: " + removeDuplicates(str));
    }
}
