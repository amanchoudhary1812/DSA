import java.util.*;

public class MergeTwo2DArrays {

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i][0] == nums2[j][0]) {

                result.add(new int[]{
                    nums1[i][0],
                    nums1[i][1] + nums2[j][1]
                });

                i++;
                j++;

            } else if (nums1[i][0] < nums2[j][0]) {

                result.add(new int[]{
                    nums1[i][0],
                    nums1[i][1]
                });

                i++;

            } else {

                result.add(new int[]{
                    nums2[j][0],
                    nums2[j][1]
                });

                j++;
            }
        }

        while (i < nums1.length) {
            result.add(new int[]{
                nums1[i][0],
                nums1[i][1]
            });
            i++;
        }

        while (j < nums2.length) {
            result.add(new int[]{
                nums2[j][0],
                nums2[j][1]
            });
            j++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input first array size
        int n1 = sc.nextInt();
        int[][] nums1 = new int[n1][2];

        for (int i = 0; i < n1; i++) {
            nums1[i][0] = sc.nextInt(); // id
            nums1[i][1] = sc.nextInt(); // value
        }

        int n2 = sc.nextInt();
        int[][] nums2 = new int[n2][2];

        for (int i = 0; i < n2; i++) {
            nums2[i][0] = sc.nextInt(); // id
            nums2[i][1] = sc.nextInt(); // value
        }

        int[][] result = mergeArrays(nums1, nums2);

        for (int[] row : result) {
            System.out.println(row[0] + " " + row[1]);
        }

        sc.close();
    }
}