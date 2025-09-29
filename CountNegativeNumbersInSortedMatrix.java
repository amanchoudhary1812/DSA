import java.util.*;

public class CountNegativeNumbersInSortedMatrix {
    // Function to count negative numbers in sorted matrix
    public static int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        int row = m - 1;  // start from bottom-left
        int col = 0;
        
        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                // if grid[row][col] is negative,
                // then everything to the right in this row is also negative
                count += (n - col);
                row--;  // move up
            } else {
                col++;  // move right
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input matrix dimensions
        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();
        
        int[][] grid = new int[m][n];
        
        System.out.println("Enter matrix elements row-wise:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int result = countNegatives(grid);
        System.out.println("Count of negative numbers = " + result);
        
        sc.close();
    }
}
