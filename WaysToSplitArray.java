import java.util.*;

public class WaysToSplitArray {

    public static int waysToSplit(int[] nums) {

        int mod = 1_000_000_007;
        int n = nums.length;

        long[] prefix = new long[n];
        prefix[0] = nums[0];

        // Build prefix sum
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long ans = 0;

        int j = 1;
        int k = 1;

        for (int i = 0; i < n - 2; i++) {

            long leftSum = prefix[i];

            // First valid middle split
            j = Math.max(j, i + 1);

            while (j < n - 1 &&
                   prefix[j] - leftSum < leftSum) {
                j++;
            }

            // First invalid middle split
            k = Math.max(k, j);

            while (k < n - 1 &&
                   prefix[n - 1] - prefix[k] >=
                   prefix[k] - leftSum) {
                k++;
            }

            ans += (k - j);
        }

        return (int)(ans % mod);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Print answer
        System.out.println(waysToSplit(nums));

        sc.close();
    }
}