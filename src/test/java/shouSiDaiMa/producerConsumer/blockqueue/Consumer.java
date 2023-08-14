package shouSiDaiMa.producerConsumer.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: jia
 * Time: 2023/3/4  15:36
 * Description:
 * Version:
 */
public class Consumer {
    ArrayBlockingQueue<Object> q;
    public Consumer(ArrayBlockingQueue<Object> q) {
        this.q = q;
    }
    public Object take() throws InterruptedException {
        return q.take();
    }
}
