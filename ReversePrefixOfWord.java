import java.util.Scanner;

public class ReversePrefixOfWord {
    public static String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        sb.reverse();
        sb.append(word.substring(index + 1));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the word: ");
        String word = scanner.nextLine();
        System.out.print("Enter the character: ");
        char ch = scanner.next().charAt(0);

        String result = reversePrefix(word, ch);
        System.out.println("Result: " + result);
    }
}
