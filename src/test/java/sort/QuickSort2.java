package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/9/9  11:27
 * Description:
 * Version: 快速排序
 */
public class QuickSort2 {

    @Test
    public void main(){
        int[] nums = new int[]{5, 2, 3, 1,6,3,7};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void quickSort(int[] nums,int left,int right){
        if (left < right){
            int pos = partition(nums,left,right);
            quickSort(nums,left,pos-1);
            quickSort(nums,pos+1,right);
        }
    }

    public int partition(int[] nums,int left,int right){
        int idx = left + 1;
        for (int i=left+1;i<=right;i++){
            if (nums[i] < nums[left]){
                swap(nums,i,idx);
                idx++;
            }
        }
        swap(nums,left,idx-1);
        return idx-1;
    }

    public void swap(int[] nums,int idx1,int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }


}
