package two_pointer_method;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode84 {
    @Test
    public void test(){

    }

    public int largestRectangleArea(int[] heights) {
        int[] leftIndex = new int[heights.length];
        int[] rightIndex = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        // 右边 第一个比它小的元素 的下标
        // 初始化 leftIndex 和 rightIndex
        Arrays.fill(rightIndex, rightIndex.length);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int index = stack.pop();
                rightIndex[index] = i;
                leftIndex[index] = stack.peek(); // 同时 计算出 左边 第一个比它小的元素 的下标
            }
            stack.push(i);
        }
        // 计算最大面积
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int weight = rightIndex[i] - leftIndex[i] - 1;
            maxArea = Math.max(maxArea,heights[i] * weight);
        }
        return maxArea;
    }

    // 双指针，超时
    public int largestRectangleArea2(int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            for (; left >= 0; left--) {
                if (heights[left] < heights[i]) break;
            }
            for (; right < heights.length; right++) {
                if (heights[right] < heights[i]) break;
            }
            int w = right - left - 1;
            int h = heights[i];
            sum = Math.max(sum, w * h);
        }
        return sum;
    }
}
