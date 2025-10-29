package prototype.news;

import java.util.Hashtable; // 使用 Hashtable 保证线程安全

// 1. 定义一个抽象原型接口 (或类)
interface Shape extends Cloneable {
    void draw();
    Object clone(); // 把 clone() 提升到接口层面
}

// 2. 创建具体原型：圆形
class Circle implements Shape {
    private String id = "1";

    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public Object clone() {
        try {
            return super.clone(); // 假设 Circle 没有引用类型，浅拷贝足矣
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// 3. 创建具体原型：矩形
class Rectangle implements Shape {
    private String id = "2";

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// 4. 关键：原型管理器 (或叫原型缓存)
class ShapeCache {
    // 使用 Hashtable 存储原型
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    // 模拟昂贵的创建过程
    public static void loadCache() {
        System.out.println("Loading cache... (Expensive operation)");
        Circle circle = new Circle();
        shapeMap.put("circle", circle);

        Rectangle rectangle = new Rectangle();
        shapeMap.put("rectangle", rectangle);
        System.out.println("Cache loaded.");
    }

    // 核心方法：从缓存中获取一个克隆
    public static Shape getShape(String shapeType) {
        Shape cachedShape = shapeMap.get(shapeType);

        // 关键：返回的是克隆！
        return (Shape) cachedShape.clone();
    }
}

// --- 客户端使用 ---
class PrototypeRegistryDemo {
    public static void main(String[] args) {
        // 1. (程序启动时) 加载一次昂贵的缓存
        ShapeCache.loadCache();

        System.out.println("--- Client requests shapes ---");

        // 2. 客户端 1 需要一个圆形
        Shape shape1 = ShapeCache.getShape("circle");
        shape1.draw();

        // 3. 客户端 2 需要另一个圆形
        Shape shape2 = ShapeCache.getShape("circle");
        shape2.draw();

        // 4. 客户端 3 需要一个矩形
        Shape shape3 = ShapeCache.getShape("rectangle");
        shape3.draw();

        // 5. 验证它们是不同的实例
        System.out.println("\n--- Verification ---");
        System.out.println("Shape1: " + shape1.hashCode());
        System.out.println("Shape2: " + shape2.hashCode());
        System.out.println("Shape3: " + shape3.hashCode());

        if (shape1 != shape2) {
            System.out.println("Shape1 and Shape2 are different instances (clones)!");
        }
    }
}
