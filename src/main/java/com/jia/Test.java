package com.jia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition notEmpty = lock.newCondition();
        Condition notFull = lock.newCondition();
        final int capacity = 10;
        List<Object> list = new ArrayList<>();
        new Thread(() -> {
            while (true){
                try {
                    lock.lock();
                    if (list.size() == capacity){
                        notFull.await();
                    }
                    list.add(new Object());
                    System.out.println("producer:" + list.size());
                    notEmpty.signal();
                    lock.unlock();
                    Thread.sleep(100);
                }catch (InterruptedException exception){
                    throw new RuntimeException(exception);
                }
            }
        },"producer").start();
        new Thread(() -> {
            while (true){
                try {
                    lock.lock();
                    if (list.isEmpty()){
                        notEmpty.await();
                    }
                    list.remove(list.size()-1);
                    System.out.println("consumer:" + list.size());
                    notFull.signal();
                    lock.unlock();
                    Thread.sleep(200);
                }catch (InterruptedException exception){
                    throw new RuntimeException(exception);
                }
            }
        },"consumer").start();
    }

}
