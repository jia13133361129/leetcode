package toOffer;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 把数组排成最小的数
 * Version:
 */
public class Offer45 {
    @Test
    public void test(){
        // int num = 34;
        // String s = String.valueOf(num);
        // System.out.println(s);
        int[] nums = {12,121};
        System.out.println(minNumber(nums));
    }

    public String minNumber(int[] nums) {
        StringBuilder ans = new StringBuilder();
        List<String> numStr = new ArrayList<>();
        for (int num : nums) {
            numStr.add(String.valueOf(num));
        }

        Collections.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                int len1 = str1.length();
                int len2 = str2.length();
                int maxLen = Math.max(len1,len2);
                for (int i = 0; i < maxLen; i++) {
                    char c1;
                    char c2;
                    if (i < len1){
                        c1 = str1.charAt(i);
                    }else {
                        c1 = str1.charAt(0);
                    }
                    if (i < len2){
                        c2 = str2.charAt(i);
                    }else {
                        c2 = str2.charAt(0);
                    }
                    if (c1 != c2){
                        return c1 - c2;
                    }
                }
                // 121 和 12 这种情况，就只能 拼接后排序
                return (str1 + str2).compareTo(str2 + str1);
            }
        });
        System.out.println(numStr);
        for (int i = 0; i < nums.length; i++) {
            ans.append(numStr.get(i));
        }

        return ans.toString();
    }



}
