package shouSiDaiMa.PrintABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Print12345 {

    public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        Condition[] conditions = new Condition[5];
        for (int i = 0; i < 5; i++) {
            conditions[i] = lock.newCondition();
        }

        for (int index = 1; index <= 5; index++) {
            int finalIndex = index;
            new Thread(new Runnable() {
                int indexCopy = finalIndex;
                @Override
                public void run() {
                    try {
                        for (int i = 0;i<5;i++){
                            lock.lock();
                            conditions[indexCopy-1].await();
                            System.out.println(indexCopy);
                            if (indexCopy == 5){
                                conditions[0].signal();
                            }else {
                                conditions[indexCopy].signal();
                            }
                            lock.unlock();
                        }
                    }catch (InterruptedException exception){
                        throw new RuntimeException(exception);
                    }
                }
            },"thread" + index).start();
            // Thread.sleep(10);
        }

        Thread.sleep(100);
        lock.lock();
        conditions[0].signal();
        lock.unlock();
    }
    // public static void main(String[] args) {
    //     new Thread(new print(0)).start();
    //     new Thread(new print(1)).start();
    //     new Thread(new print(2)).start();
    //     new Thread(new print(3)).start();
    //     new Thread(new print(4)).start();
    // }

    // public static class print implements Runnable{
    //     public int a;
    //     public print(int a){
    //         this.a = a;
    //     }
    //     @Override
    //     public void run() {
    //         while(true) {
    //             synchronized (newLock) {
    //                 if (printCount == 15) {
    //                     break;
    //                 }
    //                 if (printNumber % 5 == a) {
    //                     System.out.println(printNumber);
    //                     printNumber++;
    //                     printCount++;
    //                     if(printNumber >= 6){
    //                         printNumber = printNumber - 5;
    //                     }
    //                 }
    //
    //             }
    //         }
    //
    //     }
    // }

}
