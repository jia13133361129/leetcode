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
public class LeetCode93 {

    @Test
    public void main() {

    }

    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> restoreIpAddresses(String s) {
        backTracking(s,0,4);
        return res;
    }

    public void backTracking(String s, int startIndex, int count){
        // 剪枝
        if (count < 0){
            return;
        }
        // 模板
        if (count == 0){
            if (startIndex == s.length()){
                res.add(path.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 剪枝
            if (i - startIndex > 2){
                break;
            }
            if (i - startIndex == 2 && s.substring(startIndex,i+1).compareTo("255") > 0){
                break;
            }
            if (i - startIndex != 0 && s.substring(startIndex,i+1).startsWith("0")){
                break;
            }
            // 模板
            path.append(s, startIndex, i+1);
            if (count != 1){
                path.append(".");
            }
            count--;
            backTracking(s,i+1,count);
            count++;
            if (count != 1){
                path.deleteCharAt(path.length()-1);
            }
            path.delete(path.length() - (i-startIndex+1),path.length());
        }
    }

}
