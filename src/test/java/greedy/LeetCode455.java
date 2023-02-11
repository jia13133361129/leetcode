package greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode455 {
    @Test
    public void test(){

    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        for (int j = 0; j < s.length; j++) {
            if (g[gIndex] <= s[j]){
                gIndex++;
            }
        }
        return gIndex;
    }

}
