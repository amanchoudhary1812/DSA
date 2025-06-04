import java.util.*;

public class ShortestCompletingWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input license plate
        System.out.print("Enter license plate: ");
        String licensePlate = scanner.nextLine();

        // Input number of words
        System.out.print("Enter number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Input words
        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        // Find and print the shortest completing word
        String result = shortestCompletingWord(licensePlate, words);
        System.out.println("Shortest completing word: " + result);
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        int[] targetCount = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                targetCount[Character.toLowerCase(c) - 'a']++;
            }
        }

        String result = null;
        for (String word : words) {
            if (isCompletingWord(word, targetCount)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }
        return result;
    }

    private static boolean isCompletingWord(String word, int[] targetCount) {
        int[] wordCount = new int[26];
        for (char c : word.toCharArray()) {
            wordCount[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] < targetCount[i]) {
                return false;
            }
        }
        return true;
    }
}
