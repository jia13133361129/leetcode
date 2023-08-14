package shouSiDaiMa.singleton;

/**
 * @Author: jia
 * Time: 2023/3/1  16:10
 * Description:
 * Version:
 */
public class SingletonHungary {

    // 饿汉模式：立即加载
    // 饿汉式本身是线程安全的
    private static SingletonHungary singletonHungary = new SingletonHungary();

    //将构造器设置为private禁止通过new进行实例化
    private SingletonHungary(){};

    public SingletonHungary getInstance(){
        return singletonHungary;
    }



}
