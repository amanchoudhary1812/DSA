import java.util.Arrays;
import java.util.Scanner;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of digits: ");
        int size = scanner.nextInt();
        int[] digits = new int[size];
        
        System.out.print("Enter the digits (space-separated): ");
        for (int i = 0; i < size; i++) {
            digits[i] = scanner.nextInt();
        }
        
        int[] result = plusOne(digits);
        
        System.out.println("Output: " + Arrays.toString(result));
        
        scanner.close();
    }
    
}
