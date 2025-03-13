import java.util.Scanner;

public class Sqrt {
    public static int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        long left = 1;
        long right = x / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;

            if (square == x) 
            {
                return (int) mid;
            } 
            else if (square < x) 
            {
                left = mid + 1;
            } 
            else 
            {
                right = mid - 1;
            }
        }

        return (int) right;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");

        int x = scanner.nextInt();

        scanner.close();

        int result = mySqrt(x);

        System.out.println("The integer square root of " + x + " is: " + result);
    }
}
