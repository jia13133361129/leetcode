package shouSiDaiMa.PrintABC;

/**
 * @Author: jia
 * Time: 2023/3/1  17:15
 * Description:
 * Version:
 */
public class Main {
    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    printABC.printA();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    printABC.printB();
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    printABC.printC();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
