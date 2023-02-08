package dynamicProgramming.stock;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que309 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][5];
        dp[0][0] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
            dp[i][2] = Math.max(dp[i-1][2],Math.max(dp[i-1][1],dp[i-1][4]));
            dp[i][3] = Math.max(dp[i-1][3],dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4],dp[i-1][3] + prices[i]);
        }
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = Math.max(ans,dp[len-1][i]);
        }
        return ans;
    }


}
