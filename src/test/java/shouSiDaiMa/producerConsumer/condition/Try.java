package shouSiDaiMa.producerConsumer.condition;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jia
 * Time: 2023/3/10  10:23
 * Description:
 * Version:
 */
public class Try {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        final int capacity = 10;
        ReentrantLock lock = new ReentrantLock();
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        lock.lock();
                        while (list.size() == capacity){  // while 和 if 是不是都可以？
                            try {
                                notFull.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        list.add(new Object());
                        System.out.println("producer:" + list.size() + "," + System.currentTimeMillis ());
                        notEmpty.signal();
                    }finally {
                        lock.unlock();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"producer").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock.lock();
                        while (list.isEmpty()) {
                            try {
                                notEmpty.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        list.remove(0);
                        System.out.println("consumer:" + list.size() + "," +  System.currentTimeMillis ());
                        notFull.signal();
                    } finally {
                        lock.unlock();
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"consumer").start();
    }

//    public static void main(String[] args) throws InterruptedException {
//        int capacity = 10;
//        List<Object> list = new ArrayList<>();
//        ReentrantLock lock = new ReentrantLock();
//        Condition notEmpty = lock.newCondition();
//        Condition notFull = lock.newCondition();
//        new Thread(() -> {
//            try {
//                while (true){
//                    lock.lock();
//                    if (list.size() == capacity){
//                        notFull.await();
//                    }
//                    list.add(new Object());
//                    System.out.println("produce:" + list.size());
//                    Thread.sleep(500);
//                    notEmpty.signal();
//                    lock.unlock();
//                }
//            }catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
//        }).start();
//        new Thread(() -> {
//            try {
//                while (true){
//                    lock.lock();
//                    if (list.isEmpty()){
//                        notEmpty.await();
//                    }
//                    list.remove(0);
//                    System.out.println("consume:" + list.size());
//                    Thread.sleep(500);
//                    notFull.signal();
//                    lock.unlock();
//                }
//            }catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
//        }).start();
//    }
}
