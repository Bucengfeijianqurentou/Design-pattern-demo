package singleton;

/**
 * 饿汉式单例
 * 优点：简单，线程安全（JVM保证类加载时只执行一次静态初始化）。
 * 缺点：类加载时就创建实例，即使后续用不到，也会占用内存（无法懒加载）。
 */
public class EagerSingleton {

    // 1. 类加载时就立即创建实例
    private static final EagerSingleton INSTANCE = new EagerSingleton();

    // 2. 私有化构造函数
    private EagerSingleton() {
        // 防止反射调用
        if (INSTANCE != null) {
            throw new IllegalStateException("Instance already created!");
        }
    }

    // 3. 提供全局访问点
    public static EagerSingleton getInstance() {
        return INSTANCE;
    }

    // 示例方法
    public void showMessage() {
        System.out.println("Hello from Eager Singleton!");
    }
}
