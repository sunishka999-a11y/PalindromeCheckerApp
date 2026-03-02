import java.util.Scanner;

// Service class responsible only for palindrome checking
class PalindromeChecker {

    // Public method exposed to clients
    public boolean checkPalindrome(String input) {

        if (input == null || input.length() <= 1) {
            return true;
        }

        char[] characters = input.toCharArray();

        int start = 0;
        int end = characters.length - 1;

        while (start < end) {
            if (characters[start] != characters[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

// Application class (Client)
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check palindrome:");
        String input = scanner.nextLine();

        // Create service object
        PalindromeChecker palindromeChecker = new PalindromeChecker();

        boolean result = palindromeChecker.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}