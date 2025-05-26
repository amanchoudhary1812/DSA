import java.util.Scanner;

public class LongestPalindrome2 {
    public static int longestPalindrome(String s) {
        int[] charCounts = new int[128]; // ASCII character set size
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
        System.out.println("Length of the longest palindrome that can be built: " + result);
        scanner.close();
    }
}
