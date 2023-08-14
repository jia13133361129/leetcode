package shouSiDaiMa.ShouXieBlockQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jia
 * Time: 2023/3/4  15:48
 * Description:
 * Version:
 */
public class MyBlockingQueue<T>{
    private final List<T> list;
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int bound) {
        this.list = new ArrayList<>(bound);
        this.capacity = bound;
    }

    public T take(){
        lock.lock();
        try{
            while (list.size() == 0){
                System.out.println("队列中暂时还没数据，等待生产数据");
                notEmpty.await();
            }
            T res = list.remove(0);
            notFull.signal();
            return res;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        throw new RuntimeException("error!");
    }

    public void put(T t){
        lock.lock();
        try{
            while (list.size() == capacity){
                notFull.await();
            }
            list.add(t);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}