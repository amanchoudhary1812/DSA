import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;     // Index for the last element in nums1's initial segment
        int j = n - 1;     // Index for the last element in nums2
        int k = m + n - 1; // Index for the last position in nums1

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of nums1 (including extra space): ");
        int size1 = scanner.nextInt();
        int[] nums1 = new int[size1];
        
        System.out.print("Enter the number of initialized elements in nums1: ");
        int m = scanner.nextInt();
        System.out.println("Enter " + m + " elements of nums1: ");
        for (int i = 0; i < m; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of nums2: ");
        int n = scanner.nextInt();
        int[] nums2 = new int[n];
        
        System.out.println("Enter " + n + " elements of nums2: ");
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }

        merge(nums1, m, nums2, n);
        
        System.out.println("Merged array: " + Arrays.toString(nums1));

        scanner.close();
    }
}
