import java.util.*;

public class ShuffleeAnArray {
    private int[] original;
    private int[] array;
    private Random rand;

    public ShuffleeAnArray(int[] nums) {
        this.original = nums.clone();
        this.array = nums;
        this.rand = new Random();
    }

    public int[] reset() {
        array = original.clone();
        return array;
    }

    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(i, j);
        }
        return array;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        ShuffleeAnArray obj = new ShuffleeAnArray(nums);

        System.out.println("Shuffled array: " + Arrays.toString(obj.shuffle()));
        System.out.println("Reset array: " + Arrays.toString(obj.reset()));
        System.out.println("Shuffled again: " + Arrays.toString(obj.shuffle()));

        scanner.close();
    }
}
