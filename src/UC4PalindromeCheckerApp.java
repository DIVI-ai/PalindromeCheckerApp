public class UC4PalindromeCheckerApp {
    // UC4: Palindrome Checker using Character Array and Two-Pointer Technique
        public static void main(String[] args) {

            // Original string
            String original = "radar";

            // Convert string to character array
            char[] charArray = original.toCharArray();

            // Two pointer variables
            int start = 0;
            int end = charArray.length - 1;

            // Flag to track palindrome status
            boolean isPalindrome = true;

            // Two-pointer comparison
            while (start < end) {

                if (charArray[start] != charArray[end]) {

                    isPalindrome = false;
                    break;

                }

                start++;
                end--;
            }

            // Display result
            System.out.println("Original String: " + original);

            if (isPalindrome) {

                System.out.println("Result: It is a Palindrome");

            } else {

                System.out.println("Result: It is NOT a Palindrome");

            }

            System.out.println("Program Ends.");
        }
}

