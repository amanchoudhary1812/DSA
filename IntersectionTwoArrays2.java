import java.util.*;

public class IntersectionTwoArrays2 {

    /**
     * Finds the intersection of two arrays where each element in the result
     * should appear as many times as it shows in both arrays.
     * 
     * @param nums1 First integer array
     * @param nums2 Second integer array
     * @return Array containing the intersection elements
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array to optimize space complexity
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // HashMap to store the frequency of elements in the first array
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // List to store the intersection elements
        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (countMap.getOrDefault(num, 0) > 0) {
                intersection.add(num);  // Add to result if found in the map
                countMap.put(num, countMap.get(num) - 1); // Decrease count
            }
        }

        return intersection.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input for first array
        System.out.print("Enter size of first array: ");
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < n2; i++) 
        {
            nums2[i] = scanner.nextInt();
        }

        scanner.close(); 

        // Get intersection of arrays
        int[] result = intersect(nums1, nums2);

        // Display the intersection result
        System.out.println("Intersection of the two arrays: " + Arrays.toString(result));
    }
}
