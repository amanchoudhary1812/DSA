import java.util.*;
import java.util.regex.*;

public class MostCommonWord {
    public static void main(String[] args) {
        // Sample input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the paragraph:");
        String paragraph = scanner.nextLine();
        
        System.out.println("Enter the banned words (comma separated):");
        String bannedInput = scanner.nextLine();
        String[] banned = bannedInput.split(",\\s*");
        
        // Call the method to find the most common word
        Solution solution = new Solution();
        String result = solution.mostCommonWord(paragraph, banned);
        
        System.out.println("The most common word is: " + result);
        
        scanner.close();
    }
}

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(paragraph.toLowerCase());
        
        Map<String, Integer> wordCount = new HashMap<>();
        
        while (matcher.find()) {
            String word = matcher.group();
            if (!bannedWords.contains(word)) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        
        return mostCommon;
    }
}
