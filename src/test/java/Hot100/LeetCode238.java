package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 除自身以外数组的乘积
 * Version:
 */
public class LeetCode238 {
    @Test
    public void test(){

    }


    // 定义了左右两个数组，分别存储左边和右边的乘积
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        int[] answer = new int[len];

        leftProduct[0] = 1;
        for(int i=1;i<len;i++){
            leftProduct[i] = leftProduct[i-1] * nums[i-1];
        }

        rightProduct[len-1] = 1;
        for(int i=len-2;i>=0;i--){
            rightProduct[i] = rightProduct[i+1] * nums[i+1];
        }

        for(int i=0;i<len;i++){
            answer[i] = leftProduct[i]*rightProduct[i];
        }
        return answer;
    }




}
