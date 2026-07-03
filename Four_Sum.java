import java.util.*;

public class Four_Sum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4)
            return result;

        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            long smallest = (long) nums[i]
                    + nums[i + 1]
                    + nums[i + 2]
                    + nums[i + 3];

            if (smallest > target)
                break;

            long largest = (long) nums[i]
                    + nums[n - 1]
                    + nums[n - 2]
                    + nums[n - 3];

            if (largest < target)
                continue;

            for (int j = i + 1; j < n - 2; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    long sum = (long) nums[i]
                            + nums[j]
                            + nums[left]
                            + nums[right];

                    if (sum == target) {

                        result.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]
                        ));

                        left++;
                        right--;

                        while (left < right &&
                                nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right &&
                                nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
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

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        List<List<Integer>> ans = fourSum(nums, target);

        System.out.println("\nQuadruplets:");

        for (List<Integer> list : ans) {
            System.out.println(list);
        }

        sc.close();
    }
}