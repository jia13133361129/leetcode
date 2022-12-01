package Hot100;

import org.junit.Test;

/**
 * User: jia
 * Time: 2022/4/6  11:13
 * Description: LRU缓存
 * Version:
 */

public class LeetCode146 {

    @Test
    public void test(){
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }


    class LRUCache {

        int capacity;
        int[] keys;
        int[] values;
        int[] isUsed;
        int count=0;
        int loc=0;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            keys = new int[capacity];
            values = new int[capacity];
            isUsed = new int[capacity];
        }

        public int get(int key) {
            for(int i=0;i<loc;i++){
                if(keys[i] == key){
                    count++;
                    isUsed[i] = count;
                    return values[i];
                }
            }
            return -1;
        }

        public void put(int key, int value) {
            for(int i=0;i<loc;i++){
                if(keys[i] == key){
                    values[i] = value;
                    count++;
                    isUsed[i] = count;
                    return;
                }
            }
            if(loc < capacity){
                keys[loc] = key;
                values[loc] = value;
                count++;
                isUsed[loc] = count;
                loc++;
            }else{
                int minCount = isUsed[0];
                int minCountLoc = 0;
                for(int i=1;i<loc;i++){
                    if(isUsed[i] < minCount){
                        minCount = isUsed[i];
                        minCountLoc = i;
                    }
                }
                keys[minCountLoc] = key;
                values[minCountLoc] = value;
                count++;
                isUsed[minCountLoc] = count;
            }

        }
    }



}
