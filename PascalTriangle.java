import java.util.*;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1); // First element is always 1

            for (int j = 1; j < i; j++) {
                int sum = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(sum);
            }

            if (i > 0) {
                row.add(1); // Last element is always 1 for rows beyond the first
            }

            triangle.add(row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int numRows = scanner.nextInt();
        scanner.close();

        List<List<Integer>> result = generate(numRows);
        
        System.out.println("Pascal's Triangle:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
    
}
