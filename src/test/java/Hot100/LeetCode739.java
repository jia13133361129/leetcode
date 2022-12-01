package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 每日温度
 * 很简单
 * Version:
 */
public class LeetCode739 {
    @Test
    public void test(){

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(temperatures[j]>temperatures[i]){
                    ans[i] = j-i;
                    break;
                }
            }
        }
        return ans;
    }



}
