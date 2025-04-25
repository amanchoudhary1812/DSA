import java.util.*;

public class SortAnArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        // Input elements
        int[] nums = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Sort and print result
        SortAnArray solution = new SortAnArray();
        nums = solution.sortArray(nums);
        System.out.println("Sorted array: " + Arrays.toString(nums));
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] sorted = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                sorted[k++] = nums[i++];
            } else {
                sorted[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            sorted[k++] = nums[i++];
        }

        while (j <= right) {
            sorted[k++] = nums[j++];
        }

        System.arraycopy(sorted, 0, nums, left, sorted.length);
    }
}
