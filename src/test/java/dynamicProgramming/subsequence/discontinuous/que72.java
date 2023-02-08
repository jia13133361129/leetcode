package dynamicProgramming.subsequence.discontinuous;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que72 {
    public int lengthOfLIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

}
