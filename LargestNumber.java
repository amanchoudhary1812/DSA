import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber 
{
    public static String largestNumber(int[] nums) 
    {
        // Convert integers to strings
        String[] strNums = Arrays.stream(nums)
                                 .mapToObj(String::valueOf)
                                 .toArray(String[]::new);

        // Sort strings using custom comparator
        Arrays.sort(strNums, new Comparator<String>() 
        {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Descending order
            }
        });

        // If the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        
        System.out.println("Largest Number: " + largestNumber(nums));
    }
}
