package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jia
 * Time: 2022/9/9  11:27
 * Description:
 * Version: 快速排序
 */
public class QuickSort {

    @Test
    public void main(){
        int[] arr = new int[]{5, 2, 3, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr,int left,int right){   //当初始left设置为0，right设置为n-1时，可将整个数组排序
        if(left < right){
            int pos = partition(arr,left,right);  //经一次快排后，pos位置元素被放到其正确位置上，在其左侧元素都比其小，在其右侧元素都比其大
            quickSort(arr,left,pos-1);     //每次递归调用都给一个元素找到其正确位置
            quickSort(arr,pos+1,right);
        }
    }
    public int partition(int[] arr,int left,int right){
        // 比 arr[left] 小的元素依次放在 left+1 开始的坐标
        int index = left + 1;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[left]){
                // 把该值放入index位置
                swap(arr,index,i);
                index++;
            }
        }
        // 最后一个小于arr[left]的值 和 arr[left] 交换位置
        swap(arr,left,index-1);
        return index - 1;
    }

    // 这个快,建议写这个
    public int partition2(int arr[],int left,int right){
        int temp = arr[left];
        while(left < right){
            while(left < right && arr[right] >= temp)
                right--;
            arr[left]=arr[right];                        //将小于数轴值temp的值，向"left"的方向(也就是下标小的位置)移动
            while(left < right && arr[left] <= temp)
                left++;
            arr[right] = arr[left];						//将大于数轴值temp的值，向"right"的方向(也就是下标大的位置)移动
        }
        arr[left] = temp;
        return left;
    }


    // 交换
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
