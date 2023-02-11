package stackQueue;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description:
 * Version:
 */
public class LeetCode347 {
    @Test
    public void test(){

    }

    public int[] topKFrequent(int[] nums, int k) {
        // key : num
        // value : 频率
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // 取 前k高 项
        // 在优先队列中存储二元组(num,cnt),cnt表示元素值num在数组中的出现次数
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[1] -o2[1]);
        for (Integer key : map.keySet()) {
            if (queue.size() < k){
                queue.offer(new int[]{key,map.get(key)});
            }else {
                if (!queue.isEmpty() && map.get(key) > queue.peek()[1]){
                    queue.poll();
                    queue.offer(new int[]{key,map.get(key)});
                }
            }
        }
        // 返回
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            if (!queue.isEmpty()){
                res[i] = queue.poll()[0];
            }
        }
        return res;
    }

}
