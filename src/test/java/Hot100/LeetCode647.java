package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 回文子串
 * Version:
 */
public class LeetCode647 {
    @Test
    public void test(){

    }

    //中心扩展


    // 自己写的，用的动态规划
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int j=0;j<len;j++){
            for(int i=0;i<=j;i++){
                if(i==j){
                    dp[i][j]=true;
                    continue;
                }
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j]=false;
                }else{
                    if(j-i>=2){
                        dp[i][j] = dp[i+1][j-1];
                    }else{
                        dp[i][j]=true;
                    }
                }
            }
        }
        int count = 0;
        for(int j=0;j<len;j++)
            for(int i=0;i<=j;i++){
                if(dp[i][j]){
                    count++;
                }
            }
        return count;
    }


}
