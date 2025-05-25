import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatchingInAnArray {
    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        List<String> result = stringMatching(words);
        System.out.println("Matching substrings: " + result);
    }
}