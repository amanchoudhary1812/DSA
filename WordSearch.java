import java.util.Scanner;

public class WordSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        char[][] board = new char[rows][cols];
        System.out.println("Enter the board row by row:");
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            board[i] = line.toCharArray();
        }

        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();
        scanner.close();

        WordSearch ws = new WordSearch();
        System.out.println("Word exists: " + ws.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
            board[i][j] != word.charAt(index) || board[i][j] == '*') {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '*'; // Mark as visited

        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                        dfs(board, word, i - 1, j, index + 1) ||
                        dfs(board, word, i, j + 1, index + 1) ||
                        dfs(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // Revert to original state
        return found;
    }
}
