package Hot100;

import org.junit.Test;

import java.util.*;

/**
 * @Author: jia
 * Time: 2022/8/26  10:13
 * Description: 前 K 个高频元素
 * 堆的思想 或者 快排
 * Version:
 */
public class LeetCode347 {
    @Test
    public void test(){
        int[] nums = {-1,1,4,-4,3,5,4,-2,3,-1};
        System.out.println(Arrays.toString(topKFrequent(nums, 3)));
    }


    // 小顶堆
    // 采用优先队列
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for (Integer key : occurrences.keySet()) {
            if (queue.size() == k){
               if (queue.peek()[1] < occurrences.get(key)){
                   queue.poll();
                   queue.offer(new int[]{key,occurrences.get(key)});
               }
            }else {
                queue.offer(new int[]{key,occurrences.get(key)});
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
        return res;
    }


    //  快排实现
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // 将map移到list里面
        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        List<int[]> list = new ArrayList<>();
        for(int key : occurrences.keySet()){
            list.add(new int[]{key,occurrences.get(key)});
        }

        // for (int[] ints : list) {
        //     System.out.println(Arrays.toString(ints));
        // }

        quickSort(list,k,0,list.size()-1);

        // 取前k个
        int[] res = new int[k];
        int i = 0;
        for(int[] numFre : list){
            if(i == k){
                break;
            }
            res[i] = numFre[0];
            i++;
        }
        return res;
    }

    public void quickSort(List<int[]> list,int k,int low,int high){
        if(low < high){
            int pos = partition(list,low,high);
            if (pos == k || pos == k-1){
                return;
            }
            if (pos > k){
                quickSort(list,k,low,pos-1);
            }else{
                quickSort(list,k,pos+1,high);
            }
        }
    }


    public int partition(List<int[]> list,int low,int high){
        int[] temp = new int[]{list.get(low)[0],list.get(low)[1]};
        while (low < high){
            while (list.get(high)[1] <= temp[1] && low<high){
                high--;
            }
            list.get(low)[0] = list.get(high)[0];
            list.get(low)[1] = list.get(high)[1];

            while (list.get(low)[1] >= temp[1] && low<high){
                low++;
            }
            list.get(high)[0] = list.get(low)[0];
            list.get(high)[1] = list.get(low)[1];
        }
        list.get(low)[0] = temp[0];
        list.get(low)[1] = temp[1];
        // System.out.println("low" + low);
        return low;
    }


    // 直接使用Collections.sort()函数
    public int[] topKFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        List<HashMap.Entry<Integer, Integer>> mapList = new ArrayList<HashMap.Entry<Integer, Integer>>(hashMap.entrySet());
        Collections.sort(mapList, new Comparator<HashMap.Entry<Integer, Integer>>() {
            public int compare(HashMap.Entry<Integer, Integer> obj1, HashMap.Entry<Integer, Integer> obj2) {
                return obj2.getValue().compareTo(obj1.getValue()); // 比较map值

            }
        });
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = mapList.get(i).getKey();
        }
        return res;
    }

}
