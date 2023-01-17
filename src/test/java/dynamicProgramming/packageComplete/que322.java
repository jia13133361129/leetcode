package dynamicProgramming.packageComplete;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2023/1/14  18:12
 * Description:
 * Version:
 */
public class que322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1: dp[amount];
    }

    @Test
    public void test(){
        int max = Integer.MAX_VALUE;
        System.out.println(max+1);
        System.out.println(max < max +1);
    }
}
