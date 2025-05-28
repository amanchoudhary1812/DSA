import java.util.Scanner;

public class ThousandSeparator {
    public static String thousandSeparator(int n) {
        String s = Integer.toString(n);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (i > 0 && (s.length() - i) % 3 == 0) {
                ans.append('.');
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int input = scanner.nextInt();
        String result = thousandSeparator(input);
        System.out.println("Formatted number: " + result);
        scanner.close();
    }
}
