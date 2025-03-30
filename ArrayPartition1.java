import java.util.*;

public class ArrayPartition1 {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums); 
        int sum = 0;
        
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        if (n % 2 != 0) {
            System.out.println("Please enter an even number of elements.");
            return;
        }
        
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        
        int result = arrayPairSum(nums);
        System.out.println("Maximum sum of min elements in pairs: " + result);
    }
}
