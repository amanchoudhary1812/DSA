import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PerfectRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rectangles:");
        int n = sc.nextInt();
        int[][] rectangles = new int[n][4];

        System.out.println("Enter each rectangle in the format: x1 y1 x2 y2");
        for (int i = 0; i < n; i++) {
            rectangles[i][0] = sc.nextInt();
            rectangles[i][1] = sc.nextInt();
            rectangles[i][2] = sc.nextInt();
            rectangles[i][3] = sc.nextInt();
        }

        PerfectRectangle pr = new PerfectRectangle();
        boolean result = pr.isRectangleCover(rectangles);
        System.out.println("Perfect Rectangle: " + result);
    }

    public boolean isRectangleCover(int[][] rectangles) {
        int area = 0;
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        Set<String> corners = new HashSet<>();

        for (int[] r : rectangles) {
            area += (r[2] - r[0]) * (r[3] - r[1]);
            x1 = Math.min(x1, r[0]);
            y1 = Math.min(y1, r[1]);
            x2 = Math.max(x2, r[2]);
            y2 = Math.max(y2, r[3]);

            String[] points = new String[] {
                r[0] + " " + r[1],
                r[0] + " " + r[3],
                r[2] + " " + r[1],
                r[2] + " " + r[3]
            };
            for (String point : points) {
                if (!corners.add(point)) {
                    corners.remove(point);
                }
            }
        }

        if (corners.size() != 4) return false;
        if (!corners.contains(x1 + " " + y1) ||
            !corners.contains(x1 + " " + y2) ||
            !corners.contains(x2 + " " + y1) ||
            !corners.contains(x2 + " " + y2)) return false;

        return area == (x2 - x1) * (y2 - y1);
    }
}
