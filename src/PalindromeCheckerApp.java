// Palindrome Checker App
// Combined Use Cases UC1, UC2, UC3, UC4
import java.util.Stack;
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1: Welcome Message
        System.out.println("======================================");
        System.out.println("   Welcome to Palindrome Checker App");
        System.out.println("   Version: 1.0");
        System.out.println("======================================");

        // UC2: Hardcoded String Check
        String hardcoded = "madam";
        System.out.println("\nUC2: Hardcoded Palindrome Check");
        checkPalindromeSimple(hardcoded);

        // UC3: Reverse String Method
        String reverseMethod = "level";
        System.out.println("\nUC3: Reverse String Palindrome Check");
        checkPalindromeByReversing(reverseMethod);

        // UC4: Character Array Method
        String charArrayMethod = "radar";
        System.out.println("\nUC4: Char Array Two Pointer Check");
        checkPalindromeUsingCharArray(charArrayMethod);

        System.out.println("\nApplication Finished.");
        checkPalindromeUsingStack("madam");
    }


    // UC2 Method: Simple Check using reversing
    public static void checkPalindromeSimple(String word) {

        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {

            reversed = reversed + word.charAt(i);

        }

        if (word.equals(reversed)) {

            System.out.println(word + " is Palindrome");

        } else {

            System.out.println(word + " is NOT Palindrome");

        }

    }


    // UC3 Method: Reverse String Logic
    public static void checkPalindromeByReversing(String original) {

        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {

            reversed = reversed + original.charAt(i);

        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);

        if (original.equals(reversed)) {

            System.out.println("Palindrome");

        } else {

            System.out.println("Not Palindrome");

        }

    }


    // UC4 Method: Char Array Two Pointer
    public static void checkPalindromeUsingCharArray(String original) {

        char[] array = original.toCharArray();

        int start = 0;
        int end = array.length - 1;

        boolean isPalindrome = true;

        while (start < end) {

            if (array[start] != array[end]) {

                isPalindrome = false;
                break;

            }

            start++;
            end--;

        }

        if (isPalindrome) {

            System.out.println(original + " is Palindrome");

        } else {

            System.out.println(original + " is NOT Palindrome");


        }

    }
    // UC5: Stack Based Palindrome Checker
    public static void checkPalindromeUsingStack(String original) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < original.length(); i++) {

            stack.push(original.charAt(i));

        }

        boolean isPalindrome = true;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) != stack.pop()) {

                isPalindrome = false;
                break;

            }

        }

        if (isPalindrome)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");

    }


}
