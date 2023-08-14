package shouSiDaiMa.producerConsumer.waitNotify;

/**
 * @Author: jia
 * Time: 2023/3/1  16:44
 * Description:
 * Version:
 */
public class Producer implements Runnable{

    private Storage storage;

    public Producer(){}

    public Producer(Storage storage){
        this.storage = storage;
    }


    @Override
    public void run() {
        while (true){
            try {
                storage.producer();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
