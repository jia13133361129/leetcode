package backTracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 寻找两个正序数组的中位数
 * Version:
 */
public class LeetCode17 {

    @Test
    public void main() {
        System.out.println(numToChar('3'));
    }

    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        backTracking(digits);
        return res;
    }

    public void backTracking(String digits){
        if (digits.length() == 0){
            if(sb.length() != 0){
                res.add(sb.toString());
            }
            return;
        }
        char c = digits.charAt(0);
        char[] chars = numToChar(c);
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            backTracking(digits.substring(1));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public char[] numToChar(char c){
        int num = c - '0';
        if (num >= 1 && num <= 6){
            char temp = (char) ('a' + 3 * (num - 2));
            return new char[]{temp, (char) (temp+1), (char) (temp+2)};
        }else if (num == 7){
            char temp = 'p';
            return new char[]{temp, (char) (temp+1), (char) (temp+2), (char) (temp+3)};
        }else if (num == 8) {
            char temp = 't';
            return new char[]{temp, (char) (temp+1), (char) (temp+2)};
        }else if (num == 9) {
            char temp = 'w';
            return new char[]{temp, (char) (temp+1), (char) (temp+2), (char) (temp+3)};
        }
        return new char[]{};
    }

}
