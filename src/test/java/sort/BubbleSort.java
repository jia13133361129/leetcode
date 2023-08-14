package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2023/2/15  15:49
 * Description:
 * Version:
 */
public class BubbleSort {

    @Test
    public void test(){
        int[] nums = new int[]{2,3,23,12,54};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void bubbleSort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length-1; j++) {
                if (nums[j] >= nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
    }
}
