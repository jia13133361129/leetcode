package dynamicProgramming.stock;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que121 {
    // 1. 暴力破解（超时）
    public int maxProfit1(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                res = Math.max(res,prices[j]-prices[i]);
            }
        }
        return res;
    }

    // 2. 贪心算法
    // 取最左最小值，取最右最大值，得到的差值就是最大利润。
    // 遍历到i时，记录此时前面的最小值，依次计算取prices[i]时的利润
    public int maxProfit2(int[] prices) {
        int low = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            res = Math.max(res, prices[i] - low);
        }
        return res;
    }


    // 3. 动态规划
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }

}
