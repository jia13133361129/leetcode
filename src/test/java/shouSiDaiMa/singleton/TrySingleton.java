package shouSiDaiMa.singleton;

/**
 * @Author: jia
 * Time: 2023/3/10  11:05
 * Description:
 * Version:
 */
public class TrySingleton {

    private static volatile TrySingleton trySingleton;

    private TrySingleton(){}

    public static TrySingleton getInstance(){
        if (trySingleton == null){
            synchronized (TrySingleton.class){
                if (trySingleton == null){
                    trySingleton = new TrySingleton();
                }
            }
        }
        return trySingleton;
    }
}
