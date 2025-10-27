package singleton;

/**
 * 静态内部类实现
 * 优点：实现简单，利用 JVM 的类加载机制保证了线程安全，
 * 同时也实现了懒加载（只有在调用 getInstance 时才加载内部类）。
 * * 强烈推荐的实现方式之一。
 */
public class StaticInnerClassSingleton {

    // 1. 私有化构造函数
    private StaticInnerClassSingleton() {}

    // 2. 定义一个私有静态内部类
    private static class SingletonHolder {
        // 在内部类中创建实例
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    // 3. 提供全局访问点
    public static StaticInnerClassSingleton getInstance() {
        // 只有当 getInstance() 被调用时，JVM 才会加载 SingletonHolder 类，
        // 从而初始化 INSTANCE，这个过程是线程安全的。
        return SingletonHolder.INSTANCE;
    }
}