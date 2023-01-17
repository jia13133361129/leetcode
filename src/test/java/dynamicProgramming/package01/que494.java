package dynamicProgramming.package01;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(Math.abs(target) > sum){
            return 0;
        }
        if ((target + sum) % 2 != 0){
            return 0;
        }
        int left = (target + sum) / 2;
        int[] dp = new int[left+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = left;j >= nums[i]; j--){
                dp[j] = dp[j] + dp[j-nums[i]];
            }
        }
        return dp[left];
    }
}
