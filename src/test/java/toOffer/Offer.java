package toOffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Offer {
    @Test
    public void test(){

    }

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





}
