import java.util.Scanner;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int islands = 0, neighbors = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    islands++;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1)
                        neighbors++;
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1)
                        neighbors++;
                }
            }
        }
        return islands * 4 - neighbors * 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grid dimensions (rows and columns):");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] grid = new int[rows][cols];

        System.out.println("Enter grid values (0 for water, 1 for land):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        scanner.close();
        System.out.println("Island Perimeter: " + islandPerimeter(grid));
    }
}
