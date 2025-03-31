import java.util.Scanner;

public class RangeAddition2 {
    public static int maxCount(int m, int n, int[][] ops) {
        int minA = m;
        int minB = n;
        for (int[] op : ops) {
            minA = Math.min(minA, op[0]);
            minB = Math.min(minB, op[1]);
        }
        return minA * minB;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter matrix dimensions (m n): ");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        System.out.print("Enter number of operations: ");
        int k = scanner.nextInt();
        int[][] ops = new int[k][2];
        
        System.out.println("Enter operations (a b): ");
        for (int i = 0; i < k; i++) {
            ops[i][0] = scanner.nextInt();
            ops[i][1] = scanner.nextInt();
        }
        
        scanner.close();
        
        int result = maxCount(m, n, ops);
        System.out.println("Maximum count of integers: " + result);
    }
}