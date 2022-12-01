package Hot100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 最小覆盖子串
 * Version:
 */
public class LeetCode76 {
    @Test
    public void test(){

    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> tMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0) + 1);
        }
        int left = 0;
        int right = -1;
        int ansLeft = 0;
        int ansRight = 0;
        int ansLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            right++;
            if (right < s.length() && tMap.containsKey(s.charAt(right))){
                sMap.put(s.charAt(right),sMap.getOrDefault(s.charAt(right),0) + 1);
            }
            while (sIncludeT(sMap,tMap) && left <= right) {
                if (right - left + 1 < ansLen){
                    ansLen = right -left + 1;
                    ansLeft = left;
                    ansRight = right;
                }
                if (sMap.containsKey(s.charAt(left))) {
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left))-1);
                }
                left++;
            }
        }
        if (ansLen == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(ansLeft,ansRight+1);
    }

    public boolean sIncludeT(Map<Character,Integer> sMap,Map<Character,Integer> tMap){
        for (Character c : tMap.keySet()) {
            if (!sMap.containsKey(c)){
                return false;
            }
            if (sMap.get(c) < tMap.get(c)){
                return false;
            }
        }
        return true;
    }




}
