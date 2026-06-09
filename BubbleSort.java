import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, -2, 87, -56, 34, 77, -7, 55};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubble (int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (swapped = false) { // (!swapped)
                break;
            }
        }
    }
}
