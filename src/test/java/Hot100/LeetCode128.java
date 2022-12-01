package Hot100;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 最长连续序列
 * Version:
 */
public class LeetCode128 {
    @Test
    public void test(){

    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int maxLength = 1;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)){
                continue;
            }
            if(!set.contains(nums[i]+1)){
                continue;
            }
            int n = nums[i];
            int len = 0;
            while(set.contains(n)){
                len++;
                n++;
            }
            if(len > maxLength){
                maxLength = len;
            }
        }
        return maxLength;
    }


}
