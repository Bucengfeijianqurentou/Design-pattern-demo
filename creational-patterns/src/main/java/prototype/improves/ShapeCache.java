package prototype.improves;

import java.util.Hashtable;

public class ShapeCache {

    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    // 模拟昂贵的创建过程
    public static void loadCache() {
        System.out.println("Loading cache... (Expensive operation)");

        // 创建原型：一个位于(10,10)的圆形
        Circle circle = new Circle(new Point(10, 10), 50);
        shapeMap.put("circle", circle);

        // 创建原型：一个矩形
        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(100, 50));
        shapeMap.put("rectangle", rectangle);

        System.out.println("Cache loaded.");
    }

    // 核心方法：从缓存中获取一个克隆
    public static Shape getShape(String shapeType) {
        Shape cachedShape = shapeMap.get(shapeType);

        // 这里的 clone() 现在会触发深拷贝！
        return (Shape) cachedShape.clone();
    }
}
