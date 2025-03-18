import java.util.Scanner;

public class DuplicateNumber 
{
    public static int findDuplicate(int[] nums) 
    {
        int slow = nums[0];
        int fast = nums[0];
        
        // Detect cycle
        do 
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Find entry point of cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) 
        {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow;
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
        
        int duplicate = findDuplicate(nums);
        System.out.println("The duplicate number is: " + duplicate);
        
        scanner.close();
    }
}
