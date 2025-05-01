import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter parentheses string: ");
        String input = scanner.nextLine();
        boolean result = isValid(input);
        System.out.println("Is valid? " + result);
        scanner.close();
    }
}
