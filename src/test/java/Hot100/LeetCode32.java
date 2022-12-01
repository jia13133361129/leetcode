package Hot100;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 最长有效括号
 * 动态规划
 * Version:
 */
public class LeetCode32 {
    @Test
    public void test(){
        String s = "(()";
        System.out.println(longestValidParentheses(s));
    }

    // dp[i] 表示以i结尾的子串的最长有效括号
    // s[i] = '('时, dp[i] = 0
    // s[i] = ')',s[i-1] = '('时, dp[i] = dp[i-2] + 2
    // s[i] = ')',s[i-1] = ')',s[i-dp[i-1]-1] = '('时, dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2]
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')'){
                if (s.charAt(i-1) == '('){
                    dp[i] = i==1 ? 2 : dp[i-2]+2;
                }else{
                    if (i-dp[i-1]-1 >= 0 && s.charAt(i-dp[i-1]-1) == '('){
                        if (i-dp[i-1]-2 < 0){
                            dp[i] = dp[i-1] + 2;
                        }else{
                            dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2];
                        }
                    }
                }
                if (dp[i] > maxLength){
                    maxLength = dp[i];
                }
            }
        }
        return maxLength;
    }




}
