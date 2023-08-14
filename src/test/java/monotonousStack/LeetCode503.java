package monotonousStack;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode503 {
    @Test
    public void test(){

    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];
        // 初始化为-1
        for (int i = 0; i < ans.length; i++) {
            ans[i] = -1;
        }
        // 第一次遍历
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int index = stack.pop();
                ans[index] = nums[i];
            }
            stack.push(i);
        }
        // 第二次遍历
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                int index = stack.pop();
                if (ans[index] == -1){
                    ans[index] = nums[i];
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
