package stackQueue;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode1047 {
    @Test
    public void test(){

    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left + right);
                continue;
            }
            if (token.equals("-")) {
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left - right);
                continue;
            }
            if (token.equals("*")) {
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left * right);
                continue;
            }
            if (token.equals("/")) {
                Integer right = stack.pop();
                Integer left = stack.pop();
                stack.push(left / right);
                continue;
            }
            stack.push(strToInt(token));
        }
        return stack.pop();
    }

    public int strToInt(String s){
        return Integer.parseInt(s);
    }

}
