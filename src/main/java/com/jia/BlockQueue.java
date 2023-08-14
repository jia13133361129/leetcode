package com.jia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue<T> {
    ReentrantLock lock;
    Condition notFull;
    Condition notEmpty;
    int capacity;

    List<T> list;
    public BlockQueue(int capacity){
        this.capacity = capacity;
        list = new ArrayList<>();
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void put(T t){
        try{
            lock.lock();
            if (list.size() == capacity){
                notFull.await();
            }
            list.add(t);
            notEmpty.signal();
            lock.unlock();
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }

    public T take(){
        try{
            lock.lock();
            if (list.isEmpty()){
                notEmpty.await();
            }
            T t = list.remove(0);
            notFull.signal();
            lock.unlock();
            return t;
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
