import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumbersDisappearedInArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) 
    {
        List<Integer> missingNumbers = new ArrayList<>();

        // Mark the indices corresponding to the numbers present
        for (int num : nums) {
            int index = Math.abs(num) - 1; // Calculate index
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // Mark as negative to indicate presence
            }
        }

        // Collect the numbers corresponding to the positive indices
        for (int i = 0; i < nums.length; i++) 
        {
            if (nums[i] > 0) { // Positive value indicates missing number
                missingNumbers.add(i + 1);
            }
        }

        return missingNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        List<Integer> missingNumbers = findDisappearedNumbers(nums);
        System.out.println("Missing numbers: " + missingNumbers);
    }
}
