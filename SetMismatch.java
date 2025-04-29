import java.util.*;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int duplicate = -1;
        int missing = -1;

        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                duplicate = Math.abs(num);
            } else {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{duplicate, missing};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements (1 to n with one duplicate and one missing):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] result = findErrorNums(nums);
        System.out.println("Duplicate: " + result[0]);
        System.out.println("Missing: " + result[1]);

        scanner.close();
    }
}
