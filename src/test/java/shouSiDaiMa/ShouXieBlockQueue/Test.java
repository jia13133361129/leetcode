package shouSiDaiMa.ShouXieBlockQueue;

/**
 * @Author: jia
 * Time: 2023/3/4  16:04
 * Description:
 * Version:
 */
public class Test {
    public static void main(String[] args) {
        // MyBlockingQueue queue = new MyBlockingQueue(5);
        TryBlockingQueue queue = new TryBlockingQueue(10);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.put(i);
                System.out.println("拉个：" + i);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for(;;){
                System.out.println("屎壳郎开始工作，消费：" + queue.take());
                try {
                    Thread.sleep(150);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
