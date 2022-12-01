package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 找到字符串中所有字母异位词
 * Version:
 */
public class LeetCode438 {
    @Test
    public void test(){

    }

    // 自己写的
    // 固定长度，因此可用滑动窗口进行优化
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() < p.length()){
            return list;
        }
        for(int i=0;i<=s.length()-p.length();i++){
            String str = s.substring(i,i+p.length());
            if(isEqual(str,p)){
                list.add(i);
            }
        }
        return list;
    }

    boolean isEqual(String s1,String s2){
        int[] numS1 = new int[26];
        int[] numS2 = new int[26];
        for(int i=0;i<s1.length();i++){
            numS1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length();i++){
            numS2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
            for(int j=0;j<26;j++){
                if(numS1[i] != numS2[i]){
                    return false;
                }
            }
        return true;
    }



}
