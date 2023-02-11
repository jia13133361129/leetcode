package greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode1005 {
    @Test
    public void test(){

    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }
        }
        int ans = 0;
        // 计算和
        // k=0 或者 k为偶数
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
        }
        // k>0,k为奇数,
        if (k % 2 == 1){
            // 绝对值最小的数 变为负数,减去 两倍的绝对值最小的数
            Arrays.sort(nums);
            ans = ans - 2 * nums[0];
        }
        return ans;
    }

}
