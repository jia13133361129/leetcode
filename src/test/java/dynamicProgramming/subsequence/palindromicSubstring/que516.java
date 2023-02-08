package dynamicProgramming.subsequence.palindromicSubstring;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que516 {

    public int longestPalindromeSubseq(String s) {
        int maxLen = 1;
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--)
            for (int j = i; j < len; j++) {
                if (j == i){ // 赋初值
                    dp[i][j] = 1;
                    continue;
                }
                if (j == i + 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                }else {
                    if (s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }else {
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
                maxLen = Math.max(maxLen,dp[i][j]);
            }
        return maxLen;
    }

}
