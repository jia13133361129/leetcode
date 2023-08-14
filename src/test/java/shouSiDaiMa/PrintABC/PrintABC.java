package shouSiDaiMa.PrintABC;

/**
 * @Author: jia
 * Time: 2023/3/1  17:08
 * Description:
 * Version:
 */
public class PrintABC {
    private volatile int value = 1;

    void printA(){
        synchronized (this){
            while (value != 1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A  ");
            value = 2;
            notifyAll();
        }
    }

    void printB(){
        synchronized (this){
            while (value != 2){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B  ");
            value = 3;
            notifyAll();
        }
    }

    void printC(){
        synchronized (this){
            while (value != 3){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C  ");
            value = 1;
            notifyAll();
        }
    }

}
