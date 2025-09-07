import java.util.*;

public class KeyboardRow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words separated by spaces:");
        String input = scanner.nextLine();
        String[] words = input.trim().split("\\s+");

        String[] result = findWords(words);
        System.out.println("Words that can be typed using one row of the keyboard:");
        for (String word : result) {
            System.out.println(word);
        }
    }

    public static String[] findWords(String[] words) {

        int[] rows = new int[26];
        for (char c : "qwertyuiop".toCharArray()) rows[c - 'a'] = 1;
        for (char c : "asdfghjkl".toCharArray()) rows[c - 'a'] = 2;
        
        for (char c : "zxcvbnm".toCharArray()) rows[c - 'a'] = 3;

        List<String> result = new ArrayList<>();
        for (String word : words) {
            String lower = word.toLowerCase();
            if (lower.isEmpty()) continue;
            int row = rows[lower.charAt(0) - 'a'];
            boolean valid = true;
            for (char c : lower.toCharArray()) {
                if (rows[c - 'a'] != row) 
                {
                    valid = false;
                    break;
                }
            }
            if (valid) result.add(word);
        }
        return result.toArray(new String[0]);
    }
}
