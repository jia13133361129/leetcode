package shouSiDaiMa.producerConsumer.waitNotify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: jia
 * Time: 2023/3/1  16:42
 * Description:
 * Version:
 */
public class Storage {

    private final int capacity = 10;

    // 链表效率高一点
    private LinkedList<Object> list = new LinkedList<>();

    public void producer(){
        synchronized (list){
            while (list.size() == capacity){
                System.out.println("生产者：" + Thread.currentThread().getName() + ",仓库已满");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(new Object());
            System.out.println("生产者：" + Thread.currentThread().getName() + ";生产一个产品，当前库存：" + list.size());
            list.notifyAll();
        }
    }

    public void consumer(){
        synchronized (list){
            while (list.size() == 0){
                System.out.println("消费者：" + Thread.currentThread().getName() + ",仓库为空");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.remove(); // 链表操作
            System.out.println("消费者：" + Thread.currentThread().getName() + ";消费一个产品，当前库存：" + list.size());
            list.notifyAll();
        }
    }

}
