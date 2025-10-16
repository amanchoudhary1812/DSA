import java.util.*;

public class MinimizeMaximumOfArray {

    // Function to minimize the maximum value of array
    public static int minimizeArrayValue(int[] nums) {
        long prefixSum = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) 
        {
            prefixSum += nums[i];
            int avg = (int) Math.ceil((double) prefixSum / (i + 1));
            
            result = Math.max(result, avg);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = minimizeArrayValue(nums);
        System.out.println("Minimum possible maximum value: " + result);

        sc.close();
    }
}
