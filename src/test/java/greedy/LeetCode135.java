package greedy;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode135 {
    @Test
    public void test(){

    }

    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candyVec[i] = 1;
        }
        for (int i = 0; i < ratings.length-1; i++) {
            if (ratings[i] < ratings[i+1]){
                candyVec[i+1] = candyVec[i] + 1;
            }
        }
        for(int i = ratings.length-2;i >= 0;i--){
            if (ratings[i] > ratings[i+1]){
                candyVec[i] = Math.max(candyVec[i+1] + 1,candyVec[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < candyVec.length; i++) {
            res += candyVec[i];
        }
        return res;
    }
}
