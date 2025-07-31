class Solution {
    public int solve(int i, int buy, int t, int[] prices, int[][][] dp) {
        if (i == prices.length || t == 0) {
            return 0;
        }

        if (dp[i][buy][t] != -1) {
            return dp[i][buy][t];
        }

        int profit = 0;

        if (buy == 1) {
            profit = Math.max(
                -prices[i] + solve(i + 1, 0, t, prices, dp), 
                solve(i + 1, 1, t, prices, dp)               
            );
        } else {
            profit = Math.max(
                prices[i] + solve(i + 1, 1, t - 1, prices, dp),
                solve(i + 1, 0, t, prices, dp)                 
            );
        }

        return dp[i][buy][t] = profit;
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];

        for (int i = 0; i < n; i++) {
            for (int b = 0; b < 2; b++) {
                Arrays.fill(dp[i][b], -1);
            }
        }

        return solve(0, 1, 2, prices, dp);
    }
}