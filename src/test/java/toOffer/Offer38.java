package toOffer;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * 方法1：回溯法
 * 方法2：找出一个排列，然后计算下一个排列（leetCode 31）（没写）
 * Version:
 */
public class Offer38 {
    @Test
    public void test(){
        String[] strs = permutation("aab");
        System.out.println(Arrays.toString(strs));
    }


    // 去掉重复遍历的(剪枝)：先排序
    List<String> res;
    public String[] permutation(String s) {
        boolean[] flag = new boolean[s.length()];
        // 排序
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        res = new ArrayList<>();
        backTracking(arr,flag,new StringBuilder());
        return res.toArray(new String[res.size()]);
    }

    public void backTracking(char[] arr, boolean[] flag, StringBuilder ans){
        if (ans.length() == arr.length){
            res.add(ans.toString());
            return;
        }
        for (int i = 0; i < flag.length; i++) {
            // 相同的就不在遍历了
            if (i>0 && arr[i] == arr[i-1] && !flag[i-1]){
                continue;
            }
            if (!flag[i]){
                StringBuilder temp = new StringBuilder(ans);
                flag[i] = true;
                ans.append(arr[i]);
                backTracking(arr,flag,ans);
                ans = temp;
                flag[i] = false;
            }
        }
    }

}
