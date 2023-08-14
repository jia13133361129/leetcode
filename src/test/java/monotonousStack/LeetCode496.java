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
public class LeetCode496 {
    @Test
    public void test(){

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 求nums[2]中所有元素的下一个更大元素
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                int index = stack.pop();
                map.put(nums2[index],nums2[i]);
            }
            stack.push(i);
        }
        int[] ans = new int[nums1.length];
        // 结果复制到ans中
        for (int i=0;i<nums1.length;i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
