package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 正则表达式匹配
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * 涵盖：p包含s也行，s是p的子串
 * 例如： s="a",p="ab*",返回true
 * Version:
 */
public class LeetCode10 {
    @Test
    public void test(){

    }

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int[][] dp = new int[sLen+1][pLen+1];

        return true;

    }



}
