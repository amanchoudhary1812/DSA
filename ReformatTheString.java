import java.util.*;

public class ReformatTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        scanner.close();

        String result = reformat(s);
        System.out.println("Reformatted string: " + result);
    }

    public static String reformat(String s) {
        List<Character> letters = new ArrayList<>();
        List<Character> digits = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            } else {
                digits.add(c);
            }
        }

        if (Math.abs(letters.size() - digits.size()) > 1) {
            return "";
        }

        if (digits.size() > letters.size()) {
            List<Character> temp = letters;
            letters = digits;
            digits = temp;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < digits.size(); i++) {
            result.append(letters.get(i));
            result.append(digits.get(i));
        }

        if (letters.size() > digits.size()) {
            result.append(letters.get(letters.size() - 1));
        }

        return result.toString();
    }
}
