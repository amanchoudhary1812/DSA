import java.util.Scanner;

public class CountBinarySubstrings {
    public static int countBinarySubstrings(String s) {
        int count = 0;
        int prevRunLength = 0;
        int currRunLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currRunLength++;
            } else {
                count += Math.min(prevRunLength, currRunLength);
                prevRunLength = currRunLength;
                currRunLength = 1;
            }
        }

        count += Math.min(prevRunLength, currRunLength);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary string: ");
        String input = scanner.nextLine();
        int result = countBinarySubstrings(input);
        System.out.println("Number of valid binary substrings: " + result);
        scanner.close();
    }
} 
