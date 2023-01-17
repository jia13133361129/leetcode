package dynamicProgramming.package01;

/**
 * @Author: jia
 * Time: 2023/1/14  10:58
 * Description:
 * Version:
 */
public class que474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            int zeroNum = findNumOfZero(strs[i]);
            int oneNum = strs[i].length() - zeroNum;
            for (int j = m; j >= zeroNum; j--)
                for (int k = n; k >= oneNum; k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j-zeroNum][k-oneNum] + 1);
                }
        }
        return dp[m][n];
    }

    public int findNumOfZero(String str){
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0'){
                num++;
            }
        }
        return num;
    }
}
