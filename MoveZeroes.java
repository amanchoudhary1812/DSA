import java.util.Arrays;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) 
    {
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Before: " + Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println("After: " + Arrays.toString(nums));
    }
}
