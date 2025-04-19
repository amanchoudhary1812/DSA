import java.util.*;

public class ShiftingLetters {
    public static String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        int totalShift = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            totalShift = (totalShift + shifts[i]) % 26;
            chars[i] = (char)((chars[i] - 'a' + totalShift) % 26 + 'a');
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        System.out.print("Enter number of shifts: ");
        int n = sc.nextInt();
        int[] shifts = new int[n];

        System.out.println("Enter shift values:");
        for (int i = 0; i < n; i++) {
            shifts[i] = sc.nextInt();
        }

        String result = shiftingLetters(s, shifts);
        System.out.println("Shifted String: " + result);
    }
}
