package greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode763 {
    @Test
    public void test(){

    }

    public List<Integer> partitionLabels(String s) {
        // 记录 每个字母  最后一次出现的下标
        int[] charLoc = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charLoc[s.charAt(i)-'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        // 从头遍历字符，并更新字符的最远出现下标
        for (int i = 0; i <= end && i < s.length(); i++) {
            end = Math.max(end,charLoc[s.charAt(i)-'a']);
            // 如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
            if (i == end){
                ans.add(end-start+1);
                start = i+1;
                end = i+1;
            }
        }
        return ans;
    }
}
