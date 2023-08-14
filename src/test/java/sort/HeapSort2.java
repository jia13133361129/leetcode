package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/9/13  9:45
 * Description:
 * Version:
 */
public class HeapSort2 {

    @Test
    public void main(){
        int[] nums = new int[]{5, 2, 3, 1,2,4,2,6,9,4};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void heapSort(int[] nums){
        int len = nums.length;
        for (int i = len-1;i >= 0; i--){
            heap(nums,len,i);
        }
        for (int i = len-1;i >= 0;i--){
            swap(nums,0,i);
            heap(nums,i,0);
        }
    }

    public void heap(int[] nums,int len,int i){
        int largeIndex = i;
        int lchild = i*2+1;
        int rchild = i*2+2;
        if (lchild < len && nums[lchild] > nums[largeIndex]){
            largeIndex = lchild;
        }
        if (rchild < len && nums[rchild] > nums[largeIndex]){
            largeIndex = rchild;
        }
        if (largeIndex != i){
            swap(nums,largeIndex,i);
            heap(nums,len,largeIndex);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
