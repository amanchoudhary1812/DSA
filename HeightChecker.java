import java.util.Arrays;
import java.util.Scanner;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] heights = new int[n];
        System.out.println("Enter heights:");
        for (int i = 0; i < n; i++) 
        {
            heights[i] = scanner.nextInt();
        }

        int result = heightChecker(heights);

        System.out.println("Number of students in the wrong position: " + result);
    }
}
