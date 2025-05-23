import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JewelsAndStones {
    public static int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelSet = new HashSet<>();
        for (char j : jewels.toCharArray()) {
            jewelSet.add(j);
        }

        int count = 0;
        for (char s : stones.toCharArray()) {
            if (jewelSet.contains(s)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter jewels: ");
        String jewels = scanner.nextLine();

        System.out.print("Enter stones: ");
        String stones = scanner.nextLine();

        int result = numJewelsInStones(jewels, stones);
        System.out.println("Number of jewels in stones: " + result);

        scanner.close();
    }
}
