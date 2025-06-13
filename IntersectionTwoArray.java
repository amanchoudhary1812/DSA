import java.util.*;

public class IntersectionTwoArray 
{
    public static int[] intersection(int[] nums1, int[] nums2) 
    {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) 
        {
            set1.add(num);
        }

        Set<Integer> intersection = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) 
            {
                intersection.add(num);
            }
        }

        int[] result = new int[intersection.size()];
        int index = 0;
        for (int num : intersection) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter size of first array: ");
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        System.out.println("Enter elements of first array: ");
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        System.out.println("Enter elements of second array: ");
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }

        int[] result = intersection(nums1, nums2);
        System.out.println("Intersection of the two arrays: " + Arrays.toString(result));
        
        scanner.close();
    }
}
