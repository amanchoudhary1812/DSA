import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) 
        {
            for (int j = coin; j <= amount; j++) 
            {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of coin types: ");
        int n = scanner.nextInt();
        int[] coins = new int[n];

        System.out.println("Enter the coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.print("Enter the amount: ");
        int amount = scanner.nextInt();

        int result = coinChange(coins, amount);

        if (result == -1) 
        {
            System.out.println("It's not possible to make up the amount with the given coins.");
        } else 
        {
            System.out.println("Minimum number of coins required: " + result);
        }

        scanner.close();
    }
}
