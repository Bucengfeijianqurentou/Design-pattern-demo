package singleton;

/**
 * 双重检查锁定 (DCL)
 * 优点：实现了懒加载，且在大多数情况下性能较好。
 * 缺点：实现相对复杂。
 */
public class DclSingleton {

    // 1. 必须使用 volatile 关键字
    // 作用：
    // (1) 保证可见性：一个线程修改了 instance，其他线程能立刻看到。
    // (2) 禁止指令重排序：防止 instance = new DclSingleton() 这步操作被重排序。
    private static volatile DclSingleton instance;

    private DclSingleton() {}

    public static DclSingleton getInstance() {
        // 第一次检查：如果实例已存在，直接返回，避免不必要的加锁
        if (instance == null) {
            // 同步块：只在实例未创建时才进入
            synchronized (DclSingleton.class) {
                // 第二次检查：防止多个线程同时通过第一次检查，并在此等待
                if (instance == null) {
                    // new 操作不是原子的，可能被重排序
                    // 1. 分配内存空间
                    // 2. 初始化对象
                    // 3. 将 instance 引用指向内存空间
                    // 如果发生重排序（1->3->2），其他线程可能拿到未初始化的对象
                    // volatile 可以防止这种重排序
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }
}
