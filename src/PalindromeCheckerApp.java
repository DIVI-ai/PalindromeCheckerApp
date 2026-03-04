// Palindrome Checker App
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.LinkedList;
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

        System.out.println("\nUC5:Application Finished.");
        checkPalindromeUsingStack("madam");

        System.out.println("\nUC6: Queue + Stack Palindrome Check");
        checkPalindromeUsingQueueAndStack("madam");

        System.out.println("\nUC7: Deque Based Palindrome Check");
        checkPalindromeUsingDeque("level");
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
    // UC6: Queue + Stack Based Palindrome Check
    public static void checkPalindromeUsingQueueAndStack(String word) {

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        // Enqueue and Push characters
        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            stack.push(ch);   // LIFO
            queue.add(ch);    // FIFO

        }

        boolean isPalindrome = true;

        // Compare pop (stack) and dequeue (queue)
        for (int i = 0; i < word.length(); i++) {

            char stackChar = stack.pop();
            char queueChar = queue.remove();

            if (stackChar != queueChar) {

                isPalindrome = false;
                break;

            }
        }

        // Print result
        System.out.println("Original String: " + word);

        if (isPalindrome)
            System.out.println("Result: Palindrome");
        else
            System.out.println("Result: NOT Palindrome");

    }
    // UC7: Deque-Based Optimized Palindrome Checker
    public static void checkPalindromeUsingDeque(String word) {

        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (int i = 0; i < word.length(); i++) {

            deque.addLast(word.charAt(i));

        }

        boolean isPalindrome = true;

        // Compare front and rear
        while (deque.size() > 1) {

            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {

                isPalindrome = false;
                break;

            }

        }

        // Print result
        System.out.println("Original String: " + word);

        if (isPalindrome)
            System.out.println("Result: Palindrome");
        else
            System.out.println("Result: NOT Palindrome");

    }


}
