package greedy;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode55 {
    @Test
    public void test(){

    }


    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // 覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) { // i是下标
            coverRange = Math.max(coverRange,i + nums[i]);
            if (coverRange >= nums.length){
                return true;
            }
        }
        return false;
    }

    public boolean canJump2(int[] nums) {
        int index = 0;
        if(nums.length == 1){
            return true;
        }
        while (true){
            if (nums[index] == 0){
                return false;
            }
            int max = index + nums[index]; // 最大覆盖范围
            int maxIndex = index + nums[index]; // 下一个到达的下标
            for (int i = 1;i <= nums[index] && (index+i)<nums.length; i++){
                if (index + i + nums[index+i] > max){
                    max = index + i + nums[index+i];
                    maxIndex = index + i;
                }
            }
            if (max >= nums.length-1){
                return true;
            }else {
                index = maxIndex;
            }
        }
    }
}
