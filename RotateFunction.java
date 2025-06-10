public class RotateFunction {
    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int F = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }

        int max = F;

        for (int k = 1; k < n; k++) {
            F = F + sum - n * nums[n - k];
            max = Math.max(max, F);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 6};

        int result = maxRotateFunction(nums);
        System.out.println("Maximum Rotate Function value: " + result);
    }
}
