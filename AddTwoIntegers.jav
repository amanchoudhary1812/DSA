import java.util.Scanner;

public class AddTwoIntegers {
    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        // Calling function and printing result
        int result = sum(num1, num2);
        System.out.println("Sum = " + result);

        sc.close();
    }
}
