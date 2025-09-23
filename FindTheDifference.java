import java.util.Scanner;

public class FindTheDifference {
    public static char findTheDifference(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter string s: ");
        String s = scanner.nextLine();
        
        System.out.print("Enter string t (with one extra character): ");
        String t = scanner.nextLine();
        
        char difference = findTheDifference(s, t);
        System.out.println("The extra character is: " + difference);

        scanner.close();
    }
}
