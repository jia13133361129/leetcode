package backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 寻找两个正序数组的中位数
 * Version:
 */
public class LeetCode131 {

    @Test
    public void main() {

    }

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTracking(s,0);
        return res;
    }

    public void backTracking(String s, int startIndex){
        if (startIndex >= s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s.substring(startIndex,i + 1))){
                path.add(s.substring(startIndex, i+1));
                backTracking(s,i+1);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }



}
