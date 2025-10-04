import java.util.*;

public class MatrixSimilarityAfterCyclicShifts {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

```
    // Input rows and cols
    System.out.print("Enter number of rows: ");
    int m = sc.nextInt();
    System.out.print("Enter number of columns: ");
    int n = sc.nextInt();

    int[][] mat = new int[m][n];
    System.out.println("Enter the matrix elements row by row:");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            mat[i][j] = sc.nextInt();
        }
    }

    System.out.print("Enter k: ");
    int k = sc.nextInt();
    sc.close();

    boolean result = areSimilar(mat, k);
    System.out.println("Matrix similarity after cyclic shifts: " + result);
}

public static boolean areSimilar(int[][] mat, int k) {
    int m = mat.length;
    if (m == 0) return true;
    int n = mat[0].length;
    k %= n;

    for (int i = 0; i < m; i++) {
        if (i % 2 == 0) {
            // even row -> left shift
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != mat[i][(j + k) % n]) {
                    return false;
                }
            }
        } else {
            // odd row -> right shift
            for (int j = 0; j < n; j++) {
                int prevIdx = (j - k + n) % n;
                if (mat[i][j] != mat[i][prevIdx]) {
                    return false;
                }
            }
        }
    }
    return true;
}
```

}
