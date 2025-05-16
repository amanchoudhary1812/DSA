import java.util.Scanner;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int[] charCounts = new int[128]; // ASCII size
        for (char c : s.toCharArray()) {
            charCounts[c]++;
        }

        int length = 0;
        for (int count : charCounts) {
            length += count / 2 * 2;
            if (length % 2 == 0 && count % 2 == 1) {
                length++;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        int result = longestPalindrome(input);
        System.out.println("The length of the longest palindrome that can be built is: " + result);
    }
}
