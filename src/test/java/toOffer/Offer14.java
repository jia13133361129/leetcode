package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: I. 剪绳子
 * Version:
 */
public class Offer14 {
    @Test
    public void test(){

    }

    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2;i <= n;i++){
            dp[i] = i;
            // 不能不切
            if(i == n){
                dp[i] = 0;
            }
            for (int j=1;j < n;j++){
                if (dp[j] * (i-j) > dp[i]){
                    dp[i] = dp[j] * (i-j);
                }
            }
        }
        return dp[n];
    }


}
