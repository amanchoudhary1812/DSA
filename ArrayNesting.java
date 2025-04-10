import java.util.Scanner;

public class ArrayNesting {
    public static int arrayNesting(int[] nums) {
        int maxSize = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) continue; // Skip already visited elements
            int start = nums[i], count = 0;
            while (nums[start] != -1) {
                int temp = start;
                start = nums[start];
                nums[temp] = -1; // Mark as visited
                count++;
            }
            maxSize = Math.max(maxSize, count);
        }
        return maxSize;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array (0 to n-1):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int result = arrayNesting(nums);
        System.out.println("Length of the longest set S: " + result);

        scanner.close();
    }
}
