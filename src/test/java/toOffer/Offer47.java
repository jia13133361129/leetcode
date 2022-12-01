package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:  礼物的最大价值
 * Version:
 */
public class Offer47 {
    @Test
    public void test(){

    }

    // 从上到下 和 从下到上 是一样的
    // 因此 也可以从 开头遍历
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int j=n-1;j>=0;j--){
            for (int i= m-1;i>=0;i--) {
                if (i == m-1 && j == n-1) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                if (j == n-1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                    continue;
                }
                if (i == m-1){
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                    continue;
                }
                dp[i][j] = grid[i][j] + Math.max(dp[i+1][j],dp[i][j+1]);

            }
        }
        return dp[0][0];
    }


    public int maxValue2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int j = 1; j < n; j++) // 初始化第一行
            grid[0][j] += grid[0][j - 1];
        for(int i = 1; i < m; i++) // 初始化第一列
            grid[i][0] += grid[i - 1][0];
        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
        return grid[m - 1][n - 1];
    }


}
