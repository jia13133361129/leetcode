package two_pointer_method;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode42 {
    @Test
    public void test(){

    }

    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int max = 0;
        // 左侧最大值
        for (int i = 0; i < height.length; i++) {
            leftMax[i] = max;
            if (height[i] > max){
                max = height[i];
            }
        }
        // 右侧最大值
        max = 0;
        for (int i = height.length-1; i >= 0; i--) {
            rightMax[i] = max;
            if (height[i] > max){
                max = height[i];
            }
        }
        // 每一列雨水的高度 = min（左侧最高的柱子的高度，右侧最高的柱子中 的高度）
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(leftMax[i],rightMax[i]) - height[i];
            if (temp > 0){
                ans = ans + temp;
            }
        }
        return ans;
    }
}
