import java.util.Arrays;
import java.util.Scanner;

public class ConcatenationOfArray {
    
    // Function to concatenate the array
    public static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];        // first half
            ans[i + n] = nums[i];    // second half
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Taking input size of array
        System.out.print("Enter the number of elements in the array: ");
        
        int n = sc.nextInt();
        
        int[] nums = new int[n];
        
        // Taking input array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        // Get concatenated array
        int[] result = getConcatenation(nums);
        
        // Print the result
        System.out.println("Concatenated Array: " + Arrays.toString(result));
        
        sc.close();
    }
}
