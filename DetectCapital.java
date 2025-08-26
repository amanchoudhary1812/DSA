public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        int uppercaseCount = 0;
        int length = word.length();

        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercaseCount++;
            }
        }

        return uppercaseCount == 0 ||
            uppercaseCount == length ||
            (uppercaseCount == 1 && Character.isUpperCase(word.charAt(0)));
    }

    public static void main(String[] args) {
        // Example inputs
        String[] testWords = { "USA", "leetcode", "Google", "FlaG" };

        for (String word : testWords) {
            System.out.println("Input: " + word);
            System.out.println("Output: " + detectCapitalUse(word));
            System.out.println();
        }
    }
}
