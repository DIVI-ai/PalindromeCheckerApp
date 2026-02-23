public class UC3PalindromeCheckerApp {
    // UC3: Palindrome Checker by Reversing String using Loop
        public static void main(String[] args) {

            // Original string
            String original = "level";

            // Reversed string initially empty
            String reversed = "";

            // for loop to reverse the string
            for (int i = original.length() - 1; i >= 0; i--) {

                // String concatenation
                reversed = reversed + original.charAt(i);
            }

            // Display original and reversed string
            System.out.println("Original String : " + original);
            System.out.println("Reversed String : " + reversed);

            // Compare using equals() method
            if (original.equals(reversed)) {

                System.out.println("Result : It is a Palindrome");

            } else {

                System.out.println("Result : It is NOT a Palindrome");

            }

            System.out.println("Program Ends.");
        }
}
