package ElseQues;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 最小操作次数使数组元素相等 II
 * 个数为偶数时，变为 nums[len/2] 和 nums[len/2-1] 是一样的
 * Version:
 */
public class LeetCode462 {
    @Test
    public void test(){

    }


    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int target = nums[nums.length/2];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - target);
        }
        return res;
    }


}
