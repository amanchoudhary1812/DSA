import java.util.Scanner;

public class RangeSumQuery {
    private int[] prefix;

    public RangeSumQuery(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            prefix[i + 1] = nums[i] + prefix[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Create RangeSumQuery object
        RangeSumQuery obj = new RangeSumQuery(nums);

        // Input number of queries
        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();

        // Process queries
        for (int i = 0; i < q; i++) {
            System.out.print("Enter range (left right): ");
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            System.out.println("Sum of range [" + left + ", " + right + "] = " + obj.sumRange(left, right));
        }

        scanner.close();
    }
}
