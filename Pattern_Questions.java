

public class Pattern_Questions {
    public static void main (String[] args) {
        pattern1(4);
        pattern2(5);
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
    }
}


