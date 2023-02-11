package stackQueue;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode20 {
    @Test
    public void test(){

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')'){
                if (stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            if (s.charAt(i) == ']'){
                if (stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
            if (s.charAt(i) == '}'){
                if (stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


}
