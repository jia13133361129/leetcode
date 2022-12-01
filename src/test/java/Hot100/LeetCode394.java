package Hot100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 字符串解码
 * Version:
 */
public class LeetCode394 {
    @Test
    public void test(){

    }

    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ']'){
                stack.push(s.charAt(i));
            }else{
                // 提取字母
                StringBuilder sb = new StringBuilder();
                while(stack.peek()!='['){
                    sb.append(stack.pop());
                }
                sb.reverse();
                stack.pop();

                // 提取数字
                StringBuilder numStr = new StringBuilder();
                while(!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
                    numStr.append(stack.pop());
                }
                numStr.reverse();
                int num = Integer.parseInt(numStr.toString());

                // 构造翻倍后的字符串
                StringBuilder sb2 = new StringBuilder();
                for(int j=0;j<num;j++){
                    sb2.append(sb);
                }

                // 将翻倍后的字符串重新压入栈中
                for(int j=0;j<sb2.length();j++){
                    stack.push(sb2.charAt(j));
                }

            }
        }

        // 全部出栈。返回结果
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        res.reverse();
        return res.toString();
    }

}
