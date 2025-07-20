import java.util.Scanner;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        int i = 0;
        for (char c : t.toCharArray()) {
            if (s.charAt(i) == c) {
                i++;
                if (i == s.length()) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = scanner.nextLine();
        System.out.print("Enter string t: ");
        String t = scanner.nextLine();

        boolean result = isSubsequence(s, t);
        
        System.out.println("Is '" + s + "' a subsequence of '" + t + "'? " + result);
    }
} 
