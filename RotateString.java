import java.util.Scanner;

public class RotateString {
    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // Concatenate s with itself and check if goal is a substring
        return (s + s).contains(goal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter original string (s): ");
        String s = scanner.nextLine();

        System.out.print("Enter goal string: ");
        String goal = scanner.nextLine();

        boolean result = rotateString(s, goal);
        System.out.println("Can s be rotated to goal? " + result);

        scanner.close();
    }
}
