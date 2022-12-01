package Hot100;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:戳气球
 * Version:
 */
public class LeetCode312 {
    @Test
    public void test(){

    }

    // 方法1： 动态规划
    // https://leetcode.cn/problems/burst-balloons/solution/tu-jie-dong-tai-gui-hua-jie-jue-chuo-qi-cx18h/
    // dp[i][j] = x表示，戳破气球i和气球j之间（开区间，不包括i和j）的所有气球，可以获得的最高分数为x

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] rec = new int[n + 2][n + 2];
        // 添加两侧的虚拟气球
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        // i 应该从下往上
        for (int i = n - 1; i >= 0; i--) {
            // j 应该从左往右
            for (int j = i + 2; j <= n + 1; j++) {
                // 最后戳破的气球是哪个？
                for (int k = i + 1; k < j; k++) {
                    // 择优做选择
                    int sum = val[i] * val[k] * val[j];
                    sum += rec[i][k] + rec[k][j];
                    rec[i][j] = Math.max(rec[i][j], sum);
                }
            }
        }
        return rec[0][n + 1];
    }








    // 方法2：记忆化搜索，没太看懂
    // 将全过程看作是每次添加一个气球
    // public int[][] rec;
    // public int[] val;
    //
    // public int maxCoins(int[] nums) {
    //     // 1.添加两侧的虚拟气球，方便处理边界情况
    //     int n = nums.length;
    //     val = new int[n + 2];
    //     for (int i = 1; i <= n; i++) {
    //         val[i] = nums[i - 1];
    //     }
    //     val[0] = val[n + 1] = 1;
    //
    //     // 2.初始化
    //     rec = new int[n + 2][n + 2];
    //     for (int i = 0; i <= n + 1; i++) {
    //         Arrays.fill(rec[i], -1);
    //     }
    //     return solve(0, n + 1);
    // }
    //
    // // solve(i,j) 表示将开区间 (i,j) 内的位置全部填满气球能够得到的最多硬币数
    // public int solve(int left, int right) {
    //     if (left >= right - 1) {
    //         return 0;
    //     }
    //     if (rec[left][right] != -1) {
    //         return rec[left][right];
    //     }
    //     for (int i = left + 1; i < right; i++) {
    //         int sum = val[left] * val[i] * val[right];
    //         sum += solve(left, i) + solve(i, right);
    //         rec[left][right] = Math.max(rec[left][right], sum);
    //     }
    //     return rec[left][right];
    // }



}
