import java.util.*;

public class BinarySubarraysWithSum {

    public static int numSubarraysWithSum(int[] nums, int goal) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int num : nums) {

            prefix += num;

            count += map.getOrDefault(prefix - goal, 0);

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements (0 or 1):");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter goal: ");
        int goal = sc.nextInt();

        int ans = numSubarraysWithSum(nums, goal);

        System.out.println("Number of subarrays = " + ans);

        sc.close();
    }
}