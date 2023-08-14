package shouSiDaiMa.producerConsumer.waitNotify;

/**
 * @Author: jia
 * Time: 2023/3/1  16:45
 * Description:
 * Version:
 */
public class Consumer implements Runnable{

    private Storage storage;

    public Consumer(){}

    public Consumer(Storage storage){
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true){
            try {
                storage.consumer();
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
