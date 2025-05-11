import java.util.Scanner;

public class StringToInteger {
    public static int myAtoi(String s) {
        s = s.strip(); // Remove leading and trailing whitespaces
        if (s.isEmpty()) return 0;

        int sign = 1, i = 0;
        long result = 0;

        // Check for sign
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            i++;
        }

        // Convert digits to integer
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');

            // Clamp to 32-bit signed int range
            if (sign * result <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (sign * result >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

            i++;
        }

        return (int) (sign * result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        int result = myAtoi(input);
        System.out.println("Converted integer: " + result);
    }
}
