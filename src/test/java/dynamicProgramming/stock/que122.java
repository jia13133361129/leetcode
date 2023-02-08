package dynamicProgramming.stock;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que122 {

    // 动态规划
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]); // 和121的唯一区别
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }

}
