package dynamicProgramming.subsequence.continuous;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que674 {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }else {
                dp[i] = 1;
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

}
