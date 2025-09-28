import java.util.*;

public class CheckArrayZero {

    // LeetCode function
    public static boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i];
            nums[i] += curr;

            if (nums[i] < 0) return false; // cannot go negative

            if (nums[i] > 0) 
            {
                if (i + k > n) return false; // operation out of bounds
                curr -= nums[i];
                diff[i + k] += nums[i];
                nums[i] = 0;
            }
        }
        return true;
    }

    // Main method for input/output
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input format like question examples
        System.out.print("Enter size of array (n): ");
        int n = sc.nextInt();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[] nums = new int[n];
        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        boolean result = checkArray(nums, k);
        System.out.println("Can make all elements zero? " + result);

        sc.close();
    }
}
