import java.util.Scanner;

public class NumberOfSegmentsInString {

    public static int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        int segments = countSegments(input);
        System.out.println("Number of segments: " + segments);
        
        scanner.close();
    }
}
