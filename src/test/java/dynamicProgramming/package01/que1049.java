package dynamicProgramming.package01;

/**
 * @Author: jia
 * Time: 2023/1/13  21:33
 * Description:
 * Version:
 */
public class que1049 {

    // 01背包
    // 一维滚动dp数组
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int[] dp = new int[sum/2+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = sum/2; j >= stones[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-stones[i]] + stones[i]);
            }
        }
        return sum - dp[sum/2] - dp[sum/2];
    }
}
