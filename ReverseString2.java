public class ReverseString2 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        String result = reverseStr(s, k);
        System.out.println("Input: " + s);
        System.out.println("k: " + k);
        System.out.println("Output: " + result);
    }

    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, arr.length - 1);
            while (left < right) {
                char temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        return new String(arr);
    }
}
