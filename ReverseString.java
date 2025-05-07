import java.util.Scanner;

public class ReverseString {
    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();

        reverseString(chars);

        System.out.print("Reversed string: ");
        System.out.println(new String(chars));
    }
}
