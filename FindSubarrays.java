import java.util.*;

public class FindSubarrays {

    public static boolean findSubarrays(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];

            // If same sum already exists
            if (set.contains(sum)) {
                return true;
            }

            set.add(sum);
        }

        return false;
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

        // Print result
        System.out.println(findSubarrays(nums));

        sc.close();
    }
}