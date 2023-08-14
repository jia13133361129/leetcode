package shouSiDaiMa.PrintABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jia
 * Time: 2023/3/10  9:55
 * Description:
 * Version:
 */
// 注意：wait(),notify(),notifyAll()只能使用在同步代码块或者同步方法中
// wait(),notify(),notifyAll()的调用者必须是同步代码块或者同步方法的同步监视器(也就是锁).
// condition 的方法是 await 和 signal
public class Try {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try{
                        lock.lock();
                        try {
                            A.await();
                        } catch (InterruptedException e) {
                            System.out.println("A exception");
                            e.printStackTrace();
                        }
                        System.out.println("A");
                        B.signal();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        lock.lock();
                        try {
                            B.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("B");
                        C.signal();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try{
                        lock.lock();
                        try {
                            C.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("C");
                        A.signal();
                    }finally {
                        lock.unlock();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        A.signal();
        lock.unlock();
    }
}
