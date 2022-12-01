package Hot100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 最小栈
 * Version:
 */
public class LeetCode155 {
    @Test
    public void test(){

    }

    class MinStack {

        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<Integer>();
            minStack = new ArrayDeque<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        // 放入栈中时，最小栈中放入其最小值
        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(),val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


}
