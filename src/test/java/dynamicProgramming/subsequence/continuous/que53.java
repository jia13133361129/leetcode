package dynamicProgramming.subsequence.continuous;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],0) + nums[i];
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

}
