package greedy;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode45 {
    @Test
    public void test(){

    }

    public int jump(int[] nums) {
        int index = 0;
        if(nums.length == 1){
            return 0;
        }
        int count = 0;
        while (true){
            if (index >= nums.length -1){
                break;
            }
            int max = index + nums[index]; // 最大覆盖范围
            int maxIndex = index + nums[index]; // 下一个到达的下标
            // 下一跳就能到队尾，则退出
            if (max >=  nums.length -1){
                count++;
                break;
            }
            for (int i = 1;i <= nums[index] && (index+i)<nums.length; i++){
                if (index + i + nums[index+i] > max){
                    max = index + i + nums[index+i];
                    maxIndex = index + i;
                }
            }
            index = maxIndex;
            count++;
        }
        return count;
    }
}
