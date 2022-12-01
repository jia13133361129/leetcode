package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 和为 K 的子数组
 * Version:
 */
public class LeetCode560 {
    @Test
    public void test(){

    }

    // 枚举法
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for(int i=0;i<len;i++){
            int sum = 0;
            for(int j=i;j<len;j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }




}
