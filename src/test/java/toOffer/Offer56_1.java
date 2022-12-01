package toOffer;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 数组中数字出现的次数
 *
 * 异或操作
 * 两个性质：
 * 1. A^B^B=A，即对给定的数A，用同样的运算因子（B）作两次异或运算后仍得到A本身。
 * 2. 任何数与0进行异或，都是它本身
 *
 * 如果除了一个数字以外，其他数字都出现了两次，那么如何找到出现一次的数字：全员进行异或操作。
 * 那么如何扩展到找出两个出现一次的数字呢？
 * 如果我们可以把所有数字分成两组，使得：
 * 1. 两个只出现一次的数字在不同的组中；
 * 2. 相同的数字会被分到相同的组中。
 * 那么对两个组分别进行异或操作，即可得到答案的两个数字。
 */
public class Offer56_1 {
    @Test
    public void test(){

    }

    // 答案：异或操作
    // 1. 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
    // 2. 在异或结果中找到任意为 1 的位。
    // 3. 根据这一位对所有的数字进行分组。
    // 4. 在每个组内进行异或操作，得到两个数字。
    public int[] singleNumbers(int[] nums) {
        // 1. 先对所有数字进行一次异或，得到两个出现一次的数字的异或值。
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }

        // 2. 在异或结果中找到任意为 1 的位。
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }

        // 3. 根据这一位对所有的数字进行分组。
        // 4. 在每个组内进行异或操作，得到两个数字。
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }


    // 自己写的，取巧通过
    public int[] singleNumbers2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                set.remove(nums[i]);
            }else {
                set.add(nums[i]);
            }
        }
        int len = set.size();
        int[] ans = new int[len];
        int index = 0;
        for (Integer num : set) {
            ans[index] = num;
            index++;
        }
        return ans;
    }




}
