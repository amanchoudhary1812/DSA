import java.util.*;

public class FourDivisors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = sumFourDivisors(nums);
        System.out.println("Sum of divisors: " + result);
    }

    public static int sumFourDivisors(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            int sum = getFourDivisorsSum(num);
            totalSum += sum;
        }
        return totalSum;
    }

    private static int getFourDivisorsSum(int num) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(num); ++i) {
            if (num % i == 0) {
                int j = num / i;
                if (i == j) {
                    count++;
                    sum += i;
                } else {
                    count += 2;
                    sum += i + j;
                }
                if (count > 4) return 0;
            }
        }
        
        return count == 4 ? sum : 0;
    }
}
