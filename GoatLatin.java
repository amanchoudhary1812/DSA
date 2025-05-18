import java.util.Scanner;

public class GoatLatin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        scanner.close();

        String result = toGoatLatin(sentence);
        System.out.println("Goat Latin:");
        System.out.println(result);
    }

    public static String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (String word : sentence.split(" ")) {
            if (index > 1) {
                sb.append(" ");
            }
            if (isVowel(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(word.charAt(0));
            }
            sb.append("ma").append("a".repeat(index));
            index++;
        }
        return sb.toString();
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
