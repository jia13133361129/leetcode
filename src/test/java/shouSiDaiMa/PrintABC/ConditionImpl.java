package shouSiDaiMa.PrintABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jia
 * Time: 2023/3/4  11:38
 * Description:
 * Version:
 */
public class ConditionImpl {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Condition A = lock.newCondition(), B = lock.newCondition(), C = lock.newCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    lock.lock();
                    try {
                        A.await();
                        System.out.println("A");
                        B.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    lock.lock();
                    try {
                        B.await();
                        System.out.println("B");
                        C.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    lock.lock();
                    try {
                        C.await();
                        System.out.println("C");
                        A.signal();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }, "c").start();

        // 确保ABC都启动起来了,防止 A.signal() 之后了 A还没启动起来
        Thread.sleep(100);
        lock.lock();
        A.signal();
        lock.unlock();

        // while (Thread.activeCount() > 2){
        //     Thread.yield(); // 线程从运行状态变为就绪状态
        // }
    }


//    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock lock = new ReentrantLock();
//        Condition conditionA = lock.newCondition();
//        Condition conditionB = lock.newCondition();
//        Condition conditionC = lock.newCondition();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    for (int i = 0; i < 5; i++) {
//                        conditionA.await();
//                        System.out.println(i + "A");
//                        conditionB.signal();
//                    }
//                    lock.unlock();
//                }catch (InterruptedException e){
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    for (int i = 0; i < 5; i++) {
//                        conditionB.await();
//                        System.out.println(i + "B");
//                        conditionC.signal();
//                    }
//                    lock.unlock();
//                }catch (InterruptedException e){
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    for (int i = 0; i < 5; i++) {
//                        conditionC.await();
//                        System.out.println(i + "C");
//                        conditionA.signal();
//                    }
//                    lock.unlock();
//                }catch (InterruptedException e){
//                    throw new RuntimeException(e);
//                }
//            }
//        }).start();
//
//        Thread.sleep(50);
//        lock.lock();
//        conditionA.signal();
//        lock.unlock();
//    }
}
