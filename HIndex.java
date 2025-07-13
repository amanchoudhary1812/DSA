import java.util.Arrays;
import java.util.Scanner;

public class HIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; ++i) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of papers: ");
        int n = scanner.nextInt();
        int[] citations = new int[n];

        System.out.println("Enter citation counts:");
        for (int i = 0; i < n; i++) {
            citations[i] = scanner.nextInt();
        }

        int h = hIndex(citations);

        System.out.println("H-Index is: " + h);
        
        scanner.close();
    }
}
