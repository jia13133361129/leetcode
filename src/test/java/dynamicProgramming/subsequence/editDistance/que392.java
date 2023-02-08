package dynamicProgramming.subsequence.editDistance;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que392 {

    // 方法1：动态规划
    public boolean isSubsequence1(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if(dp[len1][len2] == len1){
            return true;
        }else{
            return false;
        }
    }

    // 方法2：动态规划
    public boolean isSubsequence2(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        boolean[][] dp = new boolean[len1+1][len2+1];
        // 初始化：第一行赋值为true
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j=1; j <= len2;j++){
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[len1][len2];
    }



    // 方法3：指针遍历
    public boolean isSubsequence3(String s, String t) {
        if (s.length() == 0)
            return false;
        int loc = -1;
        for (int i = 0; i < s.length(); i++) {
            while (loc < t.length()-1){
                loc++;
                if (s.charAt(i) == t.charAt(loc)){
                    if (i == s.length()-1)
                        return true;
                    break;
                }
            }
        }
        return false;
    }

}
