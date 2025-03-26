import java.util.Arrays;
import java.util.Scanner;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0; // Pointer for children
        int j = 0; // Pointer for cookies
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; // Child is content
            }
            j++; // Move to the next cookie
        }
        return i; // Number of content children
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of children: ");
        int n = scanner.nextInt();
        int[] g = new int[n];
        System.out.println("Enter greed factors: ");
        for (int i = 0; i < n; i++) {
            g[i] = scanner.nextInt();
        }
        
        System.out.print("Enter number of cookies: ");
        int m = scanner.nextInt();
        int[] s = new int[m];
        System.out.println("Enter cookie sizes: ");
        for (int i = 0; i < m; i++) {
            s[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        int result = findContentChildren(g, s);
        System.out.println("Maximum number of content children: " + result);
    }
}
