import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ranges;
        }

        int start = 0;
        while (start < nums.length) {
            int end = start;
            while (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) {
                end++;
            }
            if (end == start) {
                ranges.add(String.valueOf(nums[start]));
            } else {
                ranges.add(nums[start] + "->" + nums[end]);
            }
            start = end + 1;
        }
        return ranges;
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements (sorted and without duplicates):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        List<String> result = summaryRanges(nums);
        System.out.println("Summary Ranges: " + result);
    }
}

