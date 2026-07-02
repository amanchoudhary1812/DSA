import java.util.*;

public class LongestMountain {

    public static int longestMountain(int[] arr) {

        int n = arr.length;
        int ans = 0;

        int i = 1;

        while (i < n - 1) {

            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {

                int left = i;
                int right = i;

                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                ans = Math.max(ans, right - left + 1);

                i = right;
            }

            i++;
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(longestMountain(arr));

        sc.close();
    }
}