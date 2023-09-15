package shouSiDaiMa.singleton;

/**
 * @Author: jia
 * Time: 2023/3/1  16:26
 * Description:
 * Version:
 */
public class Singleton3 {

    // 使用volatile关键字防止重排序，因为 new Instance()是一个非原子操作，可能创建一个不完整的实例
    // 先把引用赋值获取，但初始化没有完成，导致别的线程访问进来的时候判断不为null，直接访问到未初始化完成的实例
    // 正确顺序：先初始化，再将引用复制
    private static volatile Singleton3 singleton3;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if (singleton3 == null){
            synchronized (Singleton3.class){
                if (singleton3 == null){
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;

    }
}
