import java.util.*;

public class MaxChunksToSorted {

    public static int maxChunksToSorted(int[] arr) {

        int max = 0;
        int chunks = 0;

        for (int i = 0; i < arr.length; i++) {

            max = Math.max(max, arr[i]);

            // Valid chunk found
            if (max == i) {
                chunks++;
            }
        }

        return chunks;
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

        // Print answer
        System.out.println(maxChunksToSorted(arr));

        sc.close();
    }
}