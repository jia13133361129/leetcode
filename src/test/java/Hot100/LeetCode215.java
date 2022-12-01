package Hot100;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 数组中的第K个最大元素
 * Version:
 */
public class LeetCode215 {
    @Test
    public void test(){

    }

    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums,0,nums.length-1,k);
    }

    public int quickSort(int[] nums,int low,int high,int k){   //设n为数组A的长度，当初始low设置为0，high设置为n-1时，可将整个数组排序
        if(low < high){
            int pos = partition(nums,low,high);
            if(pos == nums.length - k){
                return nums[pos];
            }
            if(pos > nums.length -k){
                return quickSort(nums,low,pos-1,k);
            }else{
                return quickSort(nums,pos+1,high,k);
            }
        }
        return nums[low];
    }
    public int partition(int[] nums,int low,int high){
        int temp = nums[low];
        while(low < high){
            while(low < high && nums[high] >= temp)
                high--;
            nums[low] = nums[high];
            while(low < high && nums[low] <= temp)
                low++;
            nums[high] = nums[low];
        }
        nums[low]=temp;
        return low;
    }




}
