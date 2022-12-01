package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 不同路径
 * Version:
 */
public class LeetCode62 {
    @Test
    public void test(){
        System.out.println(uniquePaths(16,16));
    }


    // long精度不够，导致结果不对
    public int uniquePaths(int m, int n) {
        int c2 = Math.min(m-1,n-1);
        int c1 = m+n-2;
        long pro1 = 1L;
        for(int i=0;i<c2;i++){
            pro1 = pro1 * c1;
            c1--;
        }
        long pro2 = 1L;
        for(int i=1;i<=c2;i++){
            pro2 = pro2 * i;
        }
        return (int)(pro1/pro2);
    }


    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < n; i++) dp[0][i] = 1;
    //     for (int i = 0; i < m; i++) dp[i][0] = 1;
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //         }
    //     }
    //     return dp[m - 1][n - 1];
    // }

}
