package dynamicProgramming.packageComplete;

/**
 * @Author: jia
 * Time: 2023/1/14  18:12
 * Description:
 * Version:
 */
public class que70 {
    public int climbStairs(int n) {
        int[] nums = {1,2};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[n];
    }
}
