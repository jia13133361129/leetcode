package Hot100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 目标和
 * Version:
 */
public class LeetCode494 {
    @Test
    public void test(){
        int[] nums = {2,107,109,113,127,131,137,3,2,3,5,7,11,13,17,19,23,29,47,53};
        System.out.println(findTargetSumWays(nums,13));
    }


    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        getExpressions(nums,0,0,target);
        return count;
    }

    public void getExpressions(int[] nums,int loc,int value,int target){
        if(loc == nums.length){
            if(value == target){
                count++;
            }
            return;
        }
        getExpressions(nums,loc+1,value+nums[loc],target);
        getExpressions(nums,loc+1,value-nums[loc],target);
    }


}
