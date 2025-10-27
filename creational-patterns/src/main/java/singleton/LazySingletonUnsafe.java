package singleton;

/**
 * 懒汉式（线程不安全）
 * 缺点：在多线程环境下，可能创建出多个实例。
 */
public class LazySingletonUnsafe {

    private static LazySingletonUnsafe instance;

    private LazySingletonUnsafe() {}

    public static LazySingletonUnsafe getInstance() {
        // 线程A执行到这里，还没new
        // 线程B也执行到这里
        if (instance == null) {
            // 线程A和B都可能执行new
            instance = new LazySingletonUnsafe();
        }
        return instance;
    }
}
