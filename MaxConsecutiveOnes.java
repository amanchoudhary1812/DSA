import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }
        return Math.max(maxCount, currentCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements (only 0s and 1s):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        int result = findMaxConsecutiveOnes(nums);
        System.out.println("Maximum consecutive ones: " + result);
        
        scanner.close();
    }
}
