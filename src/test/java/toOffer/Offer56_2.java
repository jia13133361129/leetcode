package toOffer;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:数组中数字出现的次数 II
 * 考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 3 的倍数。
 * 因此，统计所有数字的各二进制位中 1 的出现次数，并对 3 求余，结果则为只出现一次的数字。

 * Version:
 */
public class Offer56_2 {
    @Test
    public void test(){

    }


    public int singleNumber(int[] nums) {
        // 1. 建立一个长度为 32 的数组 counts ，记录所有数字的各二进制位的 1 的出现次数。
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }

        // 2. 将 counts 各元素对 333 求余，则结果为 “只出现一次的数字” 的各二进制位
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }





}
