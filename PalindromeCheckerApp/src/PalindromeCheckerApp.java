import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        // Two Pointer Approach
        long startTime1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long endTime1 = System.nanoTime();

        // Stack Approach
        long startTime2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long endTime2 = System.nanoTime();

        // Deque Approach
        long startTime3 = System.nanoTime();
        boolean result3 = dequeCheck(input);
        long endTime3 = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("----------------------------------------");

        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Execution Time: " + (endTime1 - startTime1) + " ns");

        System.out.println("\nStack Result: " + result2);
        System.out.println("Execution Time: " + (endTime2 - startTime2) + " ns");

        System.out.println("\nDeque Result: " + result3);
        System.out.println("Execution Time: " + (endTime3 - startTime3) + " ns");

        scanner.close();
    }

    // Two Pointer Approach
    private static boolean twoPointerCheck(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Stack Approach
    private static boolean stackCheck(String input) {

        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : input.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Deque Approach
    private static boolean dequeCheck(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : input.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}