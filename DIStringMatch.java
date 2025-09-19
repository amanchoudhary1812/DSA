import java.util.Arrays;
import java.util.Scanner;

public class DIStringMatch {
    public static int[] diStringMatch(String s) {
        int n = s.length();
        int low = 0, high = n;
        int[] result = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }

        
        result[n] = low; // low == high
        return result;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the DI string (only I and D): ");
        String s = scanner.nextLine();
        int[] result = diStringMatch(s);
        System.out.println("Result permutation: " + Arrays.toString(result));
        scanner.close();
    }
}
