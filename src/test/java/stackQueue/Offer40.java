package stackQueue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class Offer40 {
    @Test
    public void test(){

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < arr.length; i++) {
            if (i < k){
                queue.offer(arr[i]);
            }else {
                if (!queue.isEmpty() && arr[i] < queue.peek()){
                    queue.poll();
                    queue.offer(arr[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()){
                res[i] = queue.poll();
            }
        }
        return res;
    }


}
