import java.util.*;

public class BagOfTokens {
    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0, maxScore = 0;
        int left = 0, right = tokens.length - 1;

        while (left <= right) {
            if (power >= tokens[left]) 
            {
                power -= tokens[left++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                power += tokens[right--];
                score--;
            } else {
                break;
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of tokens: ");
        int n = scanner.nextInt();
        int[] tokens = new int[n];

        System.out.print("Enter token values: ");
        for (int i = 0; i < n; i++) {
            tokens[i] = scanner.nextInt();
        }

        System.out.print("Enter initial power: ");
        int power = scanner.nextInt();

        int result = bagOfTokensScore(tokens, power);
        System.out.println("Maximum Score: " + result);
    }
}
