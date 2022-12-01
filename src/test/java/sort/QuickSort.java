package sort;

import org.junit.Test;

/**
 * @Author: jia
 * Time: 2022/9/9  11:27
 * Description:
 * Version: 快速排序
 */
public class QuickSort {

    @Test
    public void main(){
        int[] nums = new int[]{5, 2, 3, 1};
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }


    private void quickSort(int[] nums,int low,int high){   //当初始low设置为0，high设置为n-1时，可将整个数组排序
        if(low < high){
            int pos = partition(nums,low,high);  //经一次快排后，pos位置元素被放到其正确位置上，在其左侧元素都比其小，在其右侧元素都比其大
            quickSort(nums,low,pos-1);     //每次递归调用都给一个元素找到其正确位置
            quickSort(nums,pos+1,high);
        }
    }
    private int partition(int[] nums,int low,int high){
        int temp = nums[low];
        while(low < high){
            while(low < high && nums[high] >= temp)
                high--;
            nums[low] = nums[high];  //将小于数轴值temp的值，向"low"的方向(也就是下标小的位置)移动
            while(low < high && nums[low] <= temp)
                low++;
            nums[high] = nums[low];	//将大于数轴值temp的值，向"high"的方向(也就是下标大的位置)移动
        }
        nums[low] = temp;
        return low;
    }

}
