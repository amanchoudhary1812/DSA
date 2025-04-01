import java.util.*;

public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        int count = 0;
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
                boolean emptyRight = (i == length - 1) || (flowerbed[i + 1] == 0);

                if (emptyLeft && emptyRight) {
                    flowerbed[i] = 1;
                    count++;
                    if (count >= n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of flowerbed slots: ");
        int size = scanner.nextInt();
        int[] flowerbed = new int[size];

        System.out.println("Enter the flowerbed array (0s and 1s): ");
        for (int i = 0; i < size; i++) {
            flowerbed[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of flowers to plant: ");
        int n = scanner.nextInt();

        boolean result = canPlaceFlowers(flowerbed, n);
        System.out.println("Can plant flowers? " + result);
    }
}
