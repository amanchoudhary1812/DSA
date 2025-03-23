import java.util.*;

public class IntersectionTwoArrays2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (countMap.getOrDefault(num, 0) > 0) {
                intersection.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        return intersection.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }

        scanner.close();

        int[] result = intersect(nums1, nums2);
        System.out.println("Intersection of the two arrays: " + Arrays.toString(result));
    }
}
