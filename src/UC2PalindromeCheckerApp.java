public class UC2PalindromeCheckerApp {
    // UC2: Hardcoded Palindrome Checker App

        public static void main(String[] args) {

            // Hardcoded string literal
            String word = "madam";

            // Variable to store reversed string
            String reversed = "";

            // Reverse the string using loop
            for (int i = word.length() - 1; i >= 0; i--) {
                reversed = reversed + word.charAt(i);
            }

            // Display original string
            System.out.println("Original String: " + word);

            // Conditional statement to check palindrome
            if (word.equals(reversed)) {
                System.out.println("Result: The given string is a Palindrome.");
            } else {
                System.out.println("Result: The given string is NOT a Palindrome.");
            }

            System.out.println("Program completed.");
        }
}
