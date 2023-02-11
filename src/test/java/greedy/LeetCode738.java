package greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode738 {
    @Test
    public void test(){

    }

    public int monotoneIncreasingDigits(int n) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while (n != 0){
            int num = n % 10;
            if (i == 0){
                list.add(num);
            }else {
                if (num <= list.get(i-1)){
                    list.add(num);
                }else {
                    for (int j = 0; j < i; j++) {
                        list.set(j,9);
                    }
                    list.add(num - 1);
                }
            }
            n = n / 10;
            i++;
        }
        int ans = 0;
        for (int j = list.size()-1;j >= 0;j--){
            ans = ans * 10 + list.get(j);
        }
        return ans;
    }
}
