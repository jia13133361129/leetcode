package dynamicProgramming.subsequence.editDistance;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que115 {
    public int numDistinct(String s, String t) {
        int len1 = t.length();
        int len2 = s.length();
        int[][] dp = new int[len1+1][len2+1];
        // 初始化，赋值第一行，t为null时，子序列个数都为1
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = 1;
        }
        // 递归
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[len1][len2];
    }

}
