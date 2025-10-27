package singleton;

/**
 * 懒汉式（同步方法）
 * 优点：实现了懒加载，且线程安全。
 * 缺点：性能低下。每次调用 getInstance() 都会加锁（synchronized），
 * 但实际上只有在第一次创建实例时才需要同步，后续访问已创建的实例也加锁，
 * 造成了不必要的性能开销。
 */
public class LazySingletonSynchronized {

    private static LazySingletonSynchronized instance;

    private LazySingletonSynchronized() {}

    // 使用 synchronized 保证线程安全
    public static synchronized LazySingletonSynchronized getInstance() {
        if (instance == null) {
            instance = new LazySingletonSynchronized();
        }
        return instance;
    }
}
