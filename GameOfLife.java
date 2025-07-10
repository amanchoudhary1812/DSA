import java.util.Scanner;

public class GameOfLife {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and columns:");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] board = new int[m][n];
        System.out.println("Enter the board values (0 or 1):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        gameOfLife(board);

        System.out.println("Next state of the board:");
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n);
                if (board[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    board[i][j] |= 0b10;
                } else if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] |= 0b10;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private static int countLiveNeighbors(int[][] board, int i, int j, int m, int n) 
    {
        int live = 0;
        for (int x = Math.max(0, i - 1); x <= Math.min(i + 1, m - 1); x++) 
        {
            for (int y = Math.max(0, j - 1); y <= Math.min(j + 1, n - 1); y++) 
            {
                if (x == i && y == j) continue;
                live += board[x][y] & 1;
            }
        }
        return live;
    }
}
