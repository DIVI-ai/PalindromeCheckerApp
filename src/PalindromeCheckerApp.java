// Palindrome Checker App
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

public class PalindromeCheckerApp {
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

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

        System.out.println("\nUC8: Linked List Palindrome Check");
        checkPalindromeUsingLinkedList("madam");

        System.out.println("\nUC9: Recursive Palindrome Check");

        String recursiveWord = "madam";

        if (checkPalindromeRecursive(recursiveWord, 0, recursiveWord.length() - 1))
            System.out.println("Result: Palindrome");
        else
            System.out.println("Result: NOT Palindrome");
        System.out.println("\nUC10: Case-Insensitive & Space-Ignored Palindrome");

        String sentence = "A man a plan a canal Panama";

        checkPalindromeIgnoreCaseAndSpaces(sentence);
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

    // UC8: Linked List Based Palindrome Checker
    public static void checkPalindromeUsingLinkedList(String word) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < word.length(); i++) {

            Node newNode = new Node(word.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node prev = null;
        Node current = slow;

        while (current != null) {

            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        Node firstHalf = head;
        Node secondHalf = prev;
        boolean isPalindrome = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindrome = false;
                break;

            }

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;

        }
        System.out.println("Original String: " + word);
        if (isPalindrome)
            System.out.println("Result: Palindrome");
        else
            System.out.println("Result: NOT Palindrome");
    }
    // UC9: Recursive Palindrome Checker
    public static boolean checkPalindromeRecursive(String word, int start, int end) {

        // Base condition
        if (start >= end)
            return true;

        // Compare characters
        if (word.charAt(start) != word.charAt(end))
            return false;

        // Recursive call
        return checkPalindromeRecursive(word, start + 1, end - 1);
    }
    // UC10: Case-Insensitive & Space-Ignored Palindrome Checker
    public static void checkPalindromeIgnoreCaseAndSpaces(String input) {

        // Normalize string (remove spaces and convert to lowercase)
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = normalized.length() - 1;

        boolean isPalindrome = true;

        while (start < end) {

            if (normalized.charAt(start) != normalized.charAt(end)) {

                isPalindrome = false;
                break;

            }

            start++;
            end--;

        }

        System.out.println("Original String: " + input);
        System.out.println("Normalized String: " + normalized);

        if (isPalindrome)
            System.out.println("Result: Palindrome");
        else
            System.out.println("Result: NOT Palindrome");
    }


}


