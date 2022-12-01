package toOffer;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 最长不含重复字符的子字符串
 * Version:
 */
public class Offer48 {
    @Test
    public void test(){

    }

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            maxLength = Math.max(maxLength,i-left+1);
        }
        return maxLength;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];

        if (k == 0){
            return res;
        }

        // 大根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k+1; i < arr.length; i++) {
            if (arr[i] < queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }


}
