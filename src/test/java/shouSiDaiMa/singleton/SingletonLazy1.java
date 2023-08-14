package shouSiDaiMa.singleton;

/**
 * @Author: jia
 * Time: 2023/3/1  16:15
 * Description:
 * Version:
 */
// 单例模式的懒汉实现1--线程不安全
// 延迟加载
public class SingletonLazy1 {

    private static SingletonLazy1 singletonLazy1;

    private SingletonLazy1(){}

    public SingletonLazy1 getInstance(){
        if (singletonLazy1 == null){
            return new SingletonLazy1();
        }
        return singletonLazy1;
    }
}
