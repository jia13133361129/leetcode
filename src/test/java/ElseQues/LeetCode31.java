package ElseQues;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:下一个排列
 * https://cloud.tencent.com/developer/article/1665500
 * https://www.bilibili.com/video/BV1SV411o7ac/?spm_id_from=333.337.search-card.all.click&vd_source=230ea2fd2577949cf588b55f740ec52f
 * 字符串：9 8 6 9 4 6 5 3
 * 目标： 9 8 6 9 5 3 4 6
 * 1. 从后往前 遍历到第一个不符合的降序的：4
 * 2. 从 4 开始往后找， 找到 最小的 大于 4的值 5
 * 3. 4 和 5 进行交换：后边变为6 4 3
 * 4. 把6 4 3（字典序最大）进行翻转（实质：变成字典序最小的）
 * Version:
 */
public class LeetCode31 {
    @Test
    public void test(){
        int[] nums = {1,2,3};
        // reverse(nums,0,nums.length-1);
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 字符串：9 8 6 9 4 6 5 3
    // 目标： 9 8 6 9 5 3 4 6
    public void nextPermutation(int[] nums) {
        // 1. 从后往前 遍历到第一个不符合的降序的：4
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]){
                // 2. 从 4 开始往后找， 找到 最小的 大于 4的值 5
                int index = nums.length-1;
                for (int j = i + 1; j < nums.length; j++){
                    if (nums[j] <= nums[i]){
                        index = j-1;
                        break;
                    }
                }
                // 3. 4 和 5 进行交换：后边变为6 4 3
                swap(nums,i,index);
                // 4. 把6 4 3（字典序最大）进行翻转（实质：变成字典序最小的）
                reverse(nums,i+1,nums.length-1);
                return;
            }else {
                if (i == 0){
                    reverse(nums,0,nums.length-1);
                }
            }
        }
    }

    public void reverse(int[] nums, int start, int end){
        for (int i = 0; i <= (end-start)/2; i++){
            swap(nums,start+i,end-i);
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
