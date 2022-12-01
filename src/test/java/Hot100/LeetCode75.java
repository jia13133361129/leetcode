package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 颜色分类
 * Version:
 */
public class LeetCode75 {
    @Test
    public void test(){

    }


    public void sortColors(int[] nums) {
        int redNum = 0;
        int whiteNum = 0;
        int blueNum = 0;
        for(int i=0;i<nums.length;i++){
            switch(nums[i]){
                case 0:
                    redNum++;
                    break;
                case 1:
                    whiteNum++;
                    break;
                case 2:
                    blueNum++;
                    break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(redNum != 0){
                nums[i] =0;
                redNum--;
                continue;
            }
            if(whiteNum != 0){
                nums[i] = 1;
                whiteNum--;
                continue;
            }
            if(blueNum != 0){
                nums[i] =2;
                blueNum--;
                continue;
            }
        }
    }

}
