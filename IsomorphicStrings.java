import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2)
                    return false;
            } else {
                
                if (mapTS.containsKey(c2))
                    return false;
                mapST.put(c1, c2);
                mapTS.put(c2, c1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first string: ");
        String s = scanner.nextLine();

        System.out.print("Enter second string: ");
        String t = scanner.nextLine();

        boolean result = isIsomorphic(s, t);
        
        System.out.println("Are the strings isomorphic? " + result);

        scanner.close();
    }
}
