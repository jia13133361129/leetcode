package dynamicProgramming.dajiajieshe;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que213 {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        return Math.max(robAction(nums,0,nums.length-2), robAction(nums,1,nums.length-1));
    }

    public int robAction(int[] nums, int start, int end){
        int len = end - start + 1;
        int[] dp = new int[len];
        if (len == 1){
            return nums[start];
        }
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start],nums[start+1]);
        for (int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[start+i]);
        }
        return dp[len-1];
    }
}
