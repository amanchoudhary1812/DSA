import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray solution = new RemoveDuplicatesFromSortedArray();
        
        // Example input array
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5, 5, 6}; 
        
        // Calling the function
        int newLength = solution.removeDuplicates(nums);
        
        // Printing the result
        System.out.println("New length: " + newLength);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums, newLength)));
    }
}
