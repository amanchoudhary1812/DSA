public class Pattern_Questions {
    public static void main (String[] args) {
        // pattern1(4);
        // pattern2(5);
        // pattern3(5);
        // pattern4(5);
        pattern5(5);
    }

    static void pattern1 (int n) {
        for (int row = 1; row <= n ; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void pattern2 (int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = 1; column <= n; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void pattern3 (int n) {
        for (int row = 1; row <= n; row++) {
            for (int column = row; column <= n; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void pattern4 (int n) {
        for (int row = 1; row <= n ; row++) {
            for (int column = 1; column <= row; column++) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void pattern5 (int n) {
        for (int row = 0; row <= 2*n; row++) {
            int totalColumnsInRow = row > n ? 2*n - row : row;
            for (int column = 0; column < totalColumnsInRow; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}


