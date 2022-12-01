package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 最大正方形
 * Version:
 */
public class LeetCode221 {
    @Test
    public void test(){

    }

    // // 方法1：暴力破解
    // public int maximalSquare(char[][] matrix) {
    //     int ans = 0;
    //     for(int i=0;i<matrix.length;i++)
    //         for(int j=0;j<matrix[0].length;j++){
    //             if(matrix[i][j] == '1'){
    //                 int n = square(matrix,i,j,ans+1);
    //                 if(n > ans){
    //                     ans = n;
    //                 }
    //             }
    //         }
    //     return ans*ans;
    // }
    //
    // public int square(char[][] matrix,int x,int y,int edge){
    //     while((x+edge-1) < matrix.length && (y+edge-1) < matrix[0].length){
    //         for(int i=x;i<x+edge;i++)
    //             for(int j=y;j<y+edge;j++){
    //                 if(matrix[i][j] != '1'){
    //                     return edge-1;
    //                 }
    //             }
    //         edge++;
    //     }
    //     return edge-1;
    // }



    // 方法2：动态规划
    // dp[i][j]表示以(i,j)为右下角的正方形的最大边长
    // 为1时，dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }

}
