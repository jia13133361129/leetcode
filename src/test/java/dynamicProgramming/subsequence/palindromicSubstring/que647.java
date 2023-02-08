package dynamicProgramming.subsequence.palindromicSubstring;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que647 {
    public int countSubstrings(String s) {
        int count = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // 默认赋值为false，所以只改值为true的位置
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (j == i){ // 赋初值
                    dp[i][j] = true;
                    count++;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)){
                    if (j == i + 1 || dp[i+1][j-1]){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }


}
