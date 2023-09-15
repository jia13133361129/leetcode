package sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: jia
 * Time: 2022/9/13  9:45
 * Description:
 * Version:
 */
public class HeapSort {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1-o2);

    // 节点 从 0 开始
    // 下标为 i 的节点的 父节点下标：(i-1)/2 (整数除法)
    // 下标为 i 的节点的 左孩子下标：i * 2 + 1
    // 下标为 i 的节点的 右孩子下标：i * 2 + 2

    // 原理：优先队列的底层实现
    public void heapSort(int[] arr) {
        int len = arr.length;
        // 建堆(大顶堆)
        // 初始的数组就可以看成是一个完全二叉树，建堆的过程就是从 最后一个非叶子节点 开始依次调整顺序
        // 最后一个非叶子结点下标：len / 2 - 1
        // 从最后一个 开始建堆 也行
        // len / 2 也行，好记
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr,len,i);
        }

        // 类似：取优先队列的堆顶 -> poll(堆顶) -> 重复取
        // 1. 取堆顶
        // 2. 继续维护堆顶，重复1
        // 等于 0 也行
        for (int i = len - 1; i > 0; i--)
        {
            // 把堆顶和最后一个元素交换。
            // 交换完之后，逻辑上去掉最后一个元素。
            swap(arr,0,i);
            // 重新调整堆的顺序。
            heapify(arr, i, 0);
        }
    }

    /**
     * 维护堆的性质，从下标i开始，调整堆的顺序，保持大顶堆。
     * @param arr 存储堆的数组
     * @param len 数组长度
     * @param i 待维护节点的下标
     * 调节堆，从该元素开始，一直往下调
     */
    public void heapify(int[] arr, int len, int i)
    {
        int largest = i;
        int lChild = i * 2 + 1; // 左孩子
        int rChild = i * 2 + 2; // 孩子

        // 若左孩子大于最大值，则更新最大值。
        if (lChild < len && arr[largest] < arr[lChild])
            largest = lChild;
        // 若右孩子大于最大值，则更新最大值。
        if (rChild < len && arr[largest] < arr[rChild])
            largest = rChild;

        if (largest != i) {
            swap(arr, largest,i);           // 交换值
            heapify(arr, len, largest);     // 递归调用，继续往下调整
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Test
    public void main(){
        int[] nums = new int[]{5, 2, 3, 1,2,4,2,6,9,4};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
