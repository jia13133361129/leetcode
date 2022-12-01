package ElseQues;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 买卖股票的最佳时机
 * Version:
 */
public class LeetCode121 {
    @Test
    public void test(){

    }


    // 暴力法
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] > prices[i]){
                    int t = prices[j] - prices[i];
                    if (ans < t){
                        ans = t;
                    }
                }
            }
        }
        return ans;
    }

    // 一次遍历
    // 遍历到下标 i 时， 存储 前i个 里面的最小价格
    public int maxProfit2(int[] prices) {
        int ans = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            int t = prices[i] - minPrice;
            if (t > ans){
                ans = t;
            }
        }
        return ans;
    }






}
