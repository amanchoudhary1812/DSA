import java.util.Scanner;

public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left; // Return the insert position
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for array size
        System.out.print("Enter number of elements in sorted array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        // Input sorted array elements
        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Input target element
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();
        
        // Find and print the insert position
        int position = searchInsert(nums, target);
        System.out.println("The target should be at index: " + position);

        scanner.close();
    }
    
}
