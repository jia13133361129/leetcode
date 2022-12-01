package Hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 打家劫舍1
 * 打家劫舍系列：198，213，337
 * Version:
 */
public class LeetCode198 {
    @Test
    public void test(){

    }


    // 代码随想录
    public int rob2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        //前i个房屋时能偷到的的最大金额
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }



    // 自己想的
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        // 偷第i个房屋时的最大金额
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for(int i=2;i<nums.length;i++){
            if(i==2){
                dp[i] = dp[i-2] + nums[i];
            }else{
                dp[i] = Math.max(dp[i-2],dp[i-3]) + nums[i];
            }
        }
        Arrays.sort(dp);
        return dp[nums.length-1];
    }




}
