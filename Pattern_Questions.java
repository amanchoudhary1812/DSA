public class Pattern_Questions {
    public static void main (String[] args) {
        // pattern1(4);
        // pattern2(5);
        // pattern3(5);
        pattern4(5);
        pattern5(5);
        pattern6(5);
        pattern7(5);
        pattern8(5);
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
        System.out.println();
    }

    static void pattern6 (int n) {
        for (int row = 0; row <= 2*n; row++) {
            int totalColumnsInRow = row > n ? 2*n - row : row;

            int noOfSpaces = n - totalColumnsInRow;
            for (int i = 0; i <= noOfSpaces; i++) {
                System.out.print(" ");
            }

            for (int column = 0; column < totalColumnsInRow; column++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void pattern7 (int n) {
        for (int row = 1; row <= n; row++) {
            
            for (int space = 0; space < n- row; space++) {
                System.out.print("  ");
            }

            for (int column = row; column >= 1; column--) {
                System.out.print(column + " ");
            }

            for (int column = 2; column <= row; column++) {
                System.out.print(column + " ");
            }

            System.out.println();
        }
    }

    static void pattern8 (int n) {
        for (int row = 1; row <= 2*n; row++) {
            
            int c = row > n ? 2*n - row : row;

            for (int space = 0; space < n - c; space++) {
                System.out.print("  ");
            }

            for (int column = c; column >= 1; column--) {
                System.out.print(column + " ");
            }

            for (int column = 2; column <= c; column++) {
                System.out.print(column + " ");
            }

            System.out.println();
        }
    }
}


