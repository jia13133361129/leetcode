package shouSiDaiMa.ShouXieBlockQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jia
 * Time: 2023/3/10  10:47
 * Description:
 * Version:
 */
public class TryBlockingQueue<T> {
    private final List<T> list;
    private final Integer capacity;

    private final ReentrantLock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public TryBlockingQueue(int capacity) {
        this.list = new ArrayList<>();
        this.capacity = capacity;
    }

    public void put(T t){
        try {
            lock.lock();
            while (list.size() == capacity){
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(t);
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T take(){
        try {
            lock.lock();
            while (list.size() == 0){
                try {
                    notEmpty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T remove = list.remove(0);
            notFull.signal();
            return remove;
        }finally {
            lock.unlock();
        }
    }

//    public class BlockQueue<T> {
//        ReentrantLock lock;
//        Condition notFull;
//        Condition notEmpty;
//        int capacity;
//
//        List<T> list;
//        public BlockQueue(int capacity){
//            this.capacity = capacity;
//            list = new ArrayList<>();
//            lock = new ReentrantLock();
//            notFull = lock.newCondition();
//            notEmpty = lock.newCondition();
//        }
//
//        public void put(T t){
//            try{
//                lock.lock();
//                if (list.size() == capacity){
//                    notFull.await();
//                }
//                list.add(t);
//                notEmpty.signal();
//                lock.unlock();
//            }catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
//        }
//
//        public T take(){
//            try{
//                lock.lock();
//                if (list.isEmpty()){
//                    notEmpty.await();
//                }
//                T t = list.remove(0);
//                notFull.signal();
//                lock.unlock();
//                return t;
//            }catch (InterruptedException e){
//                throw new RuntimeException(e);
//            }
//        }
//    }
}
