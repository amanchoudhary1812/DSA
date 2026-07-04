import java.util.*;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {

        int left = 0;   // Buy Day
        int right = 1;  // Sell Day

        int maxProfit = 0;

        while (right < prices.length) {

            if (prices[right] > prices[left]) {

                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);

            } else {

                // Found a cheaper buying day
                left = right;
            }

            right++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int ans = maxProfit(prices);

        System.out.println("Maximum Profit = " + ans);

        sc.close();
    }
}