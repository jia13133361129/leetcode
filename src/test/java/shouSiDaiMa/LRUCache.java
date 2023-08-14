package shouSiDaiMa;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jia
 * Time: 2023/2/15  17:25
 * Description: hash + 双向链表
 * Version:
 */
class LRUCache {

    // 参考 LinkedHashMap 的思想
    Map<Integer,Entry> map;
    Entry head,tail;
    int size = 0;
    int capacity;
    public LRUCache(int capacity){
        map = new HashMap<>();
        this.capacity = capacity;
        // 方便后面插入和删除
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            removeEntry(entry);
            addToHead(entry);
            return entry.value;
        }
        return -1;
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            Entry entry = map.get(key);
            entry.value = value;
            map.put(key,entry);
            removeEntry(entry);
            addToHead(entry);
        }else{
            Entry entry = new Entry(key,value);
            addToHead(entry);
            map.put(key,entry);
            size++;
            if(size > capacity){
                map.remove(tail.pre.key);
                removeEntry(tail.pre);
                size--;
            }
        }
    }

    public void removeEntry(Entry entry){
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
    }

    public void addToHead(Entry entry){
        head.next.pre = entry;
        entry.next = head.next;
        entry.pre = head;
        head.next = entry;
    }

    static class Entry{
        int key;
        int value;
        Entry pre;
        Entry next;

        Entry(){}
        Entry(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

}