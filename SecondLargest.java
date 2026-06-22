public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 7, 4, 9};

        int FL = Integer.MIN_VALUE;
        int SL = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > FL) {
                SL = FL;
                FL = arr[i];
            } else if (arr[i] > SL && arr[i] != FL) {
                SL = arr[i];
            }
        }
        System.out.println("Second largest number in the array is : " + SL);
    }
}
