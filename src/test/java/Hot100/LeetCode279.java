package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 完全平方数
 * Version:
 */
public class LeetCode279 {

    @Test
    public void test(){

    }

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i=1;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;;
            for(int j=1;j*j<=i;j++){
                dp[i] = Math.min(dp[i-j*j],dp[i]-1)+1;
            }
        }
        return dp[n];
    }



}
