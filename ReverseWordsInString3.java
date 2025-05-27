import java.util.Scanner;

public class ReverseWordsInString3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();

        String result = reverseWords(input);
        System.out.println("Reversed words string: " + result);
    }

    public static String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int j = 0;

        while (i < sb.length()) {
            while (i < j || (i < sb.length() && sb.charAt(i) == ' '))
                i++;
            while (j < i || (j < sb.length() && sb.charAt(j) != ' '))
                j++;
            reverse(sb, i, j - 1);
        }

        return sb.toString();
    }

    private static void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }
}
