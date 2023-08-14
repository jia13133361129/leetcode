package shouSiDaiMa.producerConsumer.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: jia
 * Time: 2023/3/4  15:32
 * Description:
 * Version:
 */
public class Producer {
    ArrayBlockingQueue<Object> q;
    public Producer(ArrayBlockingQueue<Object> q) {
        this.q = q;
    }

    public void put(Object o) throws InterruptedException {
        q.put(o);
    }
}
