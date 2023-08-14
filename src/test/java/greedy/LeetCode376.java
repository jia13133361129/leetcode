package greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode376 {
    @Test
    public void test(){

    }

    // 贪心
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int curDiff = 0; // 当前一对差值
        int preDiff = 0; // 前一对差值
        int result = 1;  // 记录峰值个数，序列默认序列最右边有一个峰值
        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i + 1] - nums[i];
            // 出现峰值
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                result++;
                preDiff = curDiff; // 注意这里，只在摆动变化的时候更新preDiff
            }
        }
        return result;
    }

    // 动态规划
    public int wiggleMaxLength2(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i][0] = Math.max(dp[i][0],dp[j][1]);
                }
                if (nums[i] < nums[j]){
                    dp[i][1] = Math.max(dp[i][0],dp[j][0]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans,Math.max(dp[i][0],dp[i][1]));
        }
        return ans;
    }

}
