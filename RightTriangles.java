public class RightTriangles {
    public static long numberOfRightTriangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCounts = new int[m];
        int[] colCounts = new int[n];

        // Count the number of 1s in each row and column
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 1) {
                    rowCounts[i]++;
                    colCounts[j]++;
                }

        long total = 0;
        // For each cell with a 1, calculate the number of right triangles
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == 1)
                    total += (long)(rowCounts[i] - 1) * (colCounts[j] - 1);

        return total;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1,0,1,1,0,0,0,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,1,0,0,0,0,0,1,0,1,0,1,0,0,1,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,1,1,1,0,0,0,0,1,0,0,0,0,1,0,1,1,1,1,1,0,1,1,0,0,1,0,0,0,1,0,0,0,1,1,0,1,1,0,1,0,1,1,0,1,0,0,0,0,0,1,1,0,0,1,0,1,0,0,1,1,0,0,1,1,0,1,1,0,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,1,0,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1,0,0,1,1,1,0,0,1,1,1,1,0,0,0,1,1,0,1,0,1,0,1,0,0,1,0,0,1,0,0,1,0,0,0,1,1,0,0,1,0,1,0,1,0,1,1,0,0,0,0,0,1,1,0,1,0,0,0,1,1,0,1,1,1,1,0,0,1,1,1,0,1,0,1,1,0,1,1,0,1,1,0,1,0,0}
        };

        System.out.println(numberOfRightTriangles(grid));
    }
}
