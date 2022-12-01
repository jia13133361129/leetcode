package toOffer;

import org.junit.Test;

import java.util.ArrayDeque;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 栈的压入、弹出序列
 * Version:
 */
public class Offer31 {
    @Test
    public void test(){

    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while (!stack.isEmpty() || i != pushed.length){
            if (stack.isEmpty()){
                stack.push(pushed[i]);
                i++;
                continue;
            }
            if (i == pushed.length && stack.peek() != popped[j]){
                return false;
            }
            if (j == popped.length){
                break;
            }
            if (stack.peek() == popped[j]){
                stack.pop();
                j++;
            }else {
                stack.push(pushed[i]);
                i++;
            }
        }
        return true;
    }



}
