import java.util.Scanner;

public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] letterCounts = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            letterCounts[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (--letterCounts[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ransom note: ");
        String ransomNote = scanner.nextLine();

        System.out.print("Enter the magazine: ");
        String magazine = scanner.nextLine();

        boolean result = canConstruct(ransomNote, magazine);
        System.out.println("Can construct ransom note: " + result);
    }
}
