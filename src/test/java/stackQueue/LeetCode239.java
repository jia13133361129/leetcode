package stackQueue;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode239 {
    @Test
    public void test(){

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int index = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        // 将 前k个元素 入队
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        // 遍历
        for (int i = k; i < nums.length; i++){
            // 赋值
            if (!deque.isEmpty()){
                ans[index] = deque.peekFirst();
                index++;
            }
            // 出队，在队首，删除
            if (!deque.isEmpty() && deque.peekFirst() == nums[i-k]){
                deque.pollFirst();
            }
            // 入队nums[i]
            while (!deque.isEmpty() && deque.peekLast() < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        // 赋值
        if (!deque.isEmpty()){
            ans[index] = deque.peekFirst();
        }
        return ans;
    }

}
