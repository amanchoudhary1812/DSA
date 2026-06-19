import java.util.*;

public class ArrayOfDoubledPairs {

    public static boolean canReorderDoubled(int[] arr) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Integer[] nums = new Integer[arr.length];

        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        Arrays.sort(nums, (a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        for (int num : nums) {

            if (freq.get(num) == 0) {
                continue;
            }

            int doubled = num * 2;

            if (freq.getOrDefault(doubled, 0) <= 0) {
                return false;
            }

            freq.put(num, freq.get(num) - 1);

            freq.put(doubled, freq.get(doubled) - 1);
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(canReorderDoubled(arr));

        sc.close();
    }
}