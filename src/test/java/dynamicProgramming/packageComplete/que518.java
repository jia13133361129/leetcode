package dynamicProgramming.packageComplete;

/**
 * @Author: jia
 * Time: 2023/1/14  16:07
 * Description:
 * Version:
 */
public class que518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++){
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }
}
