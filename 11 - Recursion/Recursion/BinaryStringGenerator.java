public class BinaryStringGenerator {

    // Recursive helper function to generate strings
    public static void generateBinaryStrings(int n, String str) {
        // Base case: if the string reaches the required length, print it
        if (str.length() == n) {
            System.out.println(str);
            return;
        }

        // Add '0' to the current string and recurse
        generateBinaryStrings(n, str + "0");

        // Add '1' to the current string only if the last character is not '1'
        if (str.isEmpty() || str.charAt(str.length() - 1) != '1') {
            generateBinaryStrings(n, str + "1");
        }
    }

    // Wrapper function to start the recursion
    public static void generateBinaryStrings(int n) {
        generateBinaryStrings(n, "");
    }

    // Main method for testing
    public static void main(String[] args) {
        int n = 3;
        System.out.println("All binary strings of length " + n + " without consecutive 1s:");
        generateBinaryStrings(n);
    }
}
