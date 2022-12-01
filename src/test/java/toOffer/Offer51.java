package toOffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 数组中的逆序对
 * Version:
 */
public class Offer51 {
    @Test
    public void test(){

    }

    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] > nums[j]){
                    count++;
                }
            }
        }
        return count;
    }



}
