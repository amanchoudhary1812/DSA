import java.util.Scanner;

public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        String trimmed = doubled.substring(1, doubled.length() - 1);
        return trimmed.contains(s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        scanner.close();

        boolean result = repeatedSubstringPattern(input);
        System.out.println("Repeated Substring Pattern? " + result);
    }
}
