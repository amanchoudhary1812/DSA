public class InfiniteArray {
    public static void main (String[] args) {
    
        int[] arr = {1, 12, 16, 17, 18 , 21, 32, 63, 77, 89, 99, 100, 120, 140, 160, 170, 180};
        int target = 160;
        System.out.println(ans(arr, target));
    }

    static int ans (int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (target > arr[end]) {
            int newStart = end + 1;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return binarySearch (arr, target, start, end);
    }

    static int binarySearch (int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
