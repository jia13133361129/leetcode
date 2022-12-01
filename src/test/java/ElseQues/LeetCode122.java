package ElseQues;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 买卖股票的最佳时机 II
 * 同时持有：1股
 * 买卖：无数次
 * 无手续费
 */
public class LeetCode122 {
    @Test
    public void test(){

    }

    /**
     * 动态规划
     * dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，
     * dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润
     * dp[i][0] = max{ dp[i−1][0], dp[i−1][1]+prices[i]}
     * dp[i][1] = max{ dp[i−1][1], dp[i−1][0]−prices[i]}
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][1];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
    }


    /**
     * 贪心算法（这道题是特例）
     * 由于不限制交易次数，只要今天股价比昨天高，就交易。
     *
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }

}
