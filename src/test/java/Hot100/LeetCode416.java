package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 分割等和子集
 * 要求集合里能否出现总和为 sum / 2 的子集
 * 动态规划
 * Version:
 */
public class LeetCode416 {
    @Test
    public void test(){

    }

    // dp[i][j] 表示前 i 个物品中能否找到总和为 j 的子集
    // 可优化为一维数组
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum = sum + num;
        }
        if(sum % 2 != 0){
            return false;
        }
        int size = sum/2;
        boolean[][] dp = new boolean[nums.length][size+1];
        if(nums[0]<=size){
            dp[0][nums[0]] = true;
        }
        for(int i=1;i<nums.length;i++){
            int n = nums[i];
            if(n <= size){
                dp[i][n] = true;
                for(int j=0;j<=size;j++){
                    if(dp[i-1][j]){
                        dp[i][j] = true;
                        if(j+nums[i] <= size){
                            dp[i][j+nums[i]] = true;
                        }
                    }
                }
            }
            if(dp[i][size]){
                return true;
            }
        }
        return false;

    }



}
