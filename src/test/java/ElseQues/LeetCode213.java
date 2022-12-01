package ElseQues;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 打家劫舍2
 * Version:
 */
public class LeetCode213 {
    @Test
    public void test(){

    }

    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        // 不偷尾 和 不偷首 的最大值
        // 这样就避免了成环
        return Math.max(robRange(nums,0,nums.length-2),robRange(nums,1,nums.length-1));

    }

    public int robRange(int[] nums,int start,int end) {
        if(end == start){
            return nums[start];
        }
        //前i个房屋时能偷到的的最大金额
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);

        for(int i=start+2;i<=end;i++){
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[end];
    }

}
