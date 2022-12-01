package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 最短无序连续子数组
 * Version:
 */
public class LeetCode581 {
    @Test
    public void test(){

    }


    // 自己做的，时间复杂度太高
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    start = i;
                    break;
                }
            }
            if(start != -1){
                break;
            }
        }
        if(start == -1){
            return 0;
        }
        int end = nums.length;
        for(int i=nums.length-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                if(nums[j]>nums[i]){
                    end = i;
                    break;
                }
            }
            if(end != nums.length){
                break;
            }
        }
        return end-start+1;
    }

}
