package shouSiDaiMa.producerConsumer.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: jia
 * Time: 2023/3/4  15:33
 * Description:
 * Version:
 */
public class Main {

    public static void main(String[] args) {
        ArrayBlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Producer producer = new Producer(blockingQueue);
                while (true) {
                    try {
                        producer.put(new Object());
                        System.out.println("Producer:" + blockingQueue.size());
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Consumer consumer = new Consumer(blockingQueue);
                while (true){
                    try {
                        consumer.take();
                        System.out.println("Consumer:" + blockingQueue.size());
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
