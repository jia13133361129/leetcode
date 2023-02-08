package dynamicProgramming.stock;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que188 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][k*2+1];
        // 初始化，只修改值不为0的
        for (int i = 0; i < k; i++) {
            dp[0][2*i+1] = -prices[0];
        }
        // 递归
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2 * k; j++){
                if (j % 2 == 0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1] + prices[i]);
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1] - prices[i]);
                }
            }
        }
        int ans = 0;
        for (int j = 1; j <= 2 * k; j++){
            ans = Math.max(ans,dp[len-1][j]);
        }
        return ans;
    }


}
