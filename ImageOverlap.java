import java.util.*;

public class ImageOverlap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter matrix size n: ");
        int n = sc.nextInt();

        int[][] img1 = new int[n][n];
        int[][] img2 = new int[n][n];

        System.out.println("Enter elements of img1:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                img1[i][j] = sc.nextInt();

        System.out.println("Enter elements of img2:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                img2[i][j] = sc.nextInt();

        Solution sol = new Solution();

        int result = sol.largestOverlap(img1, img2);

        System.out.println("Maximum overlap: " + result);
    }
}

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) ones1.add(new int[]{i, j});
                if (img2[i][j] == 1) ones2.add(new int[]{i, j});
            }

        int maxOverlap = 0;
        for (int[] a : ones1)
            for (int[] b : ones2) 
            {
                String shift = (a[0] - b[0]) + "," + (a[1] - b[1]);
                countMap.put(shift, countMap.getOrDefault(shift, 0) + 1);
                maxOverlap = Math.max(maxOverlap, countMap.get(shift));
            }

        return maxOverlap;
    }
}
