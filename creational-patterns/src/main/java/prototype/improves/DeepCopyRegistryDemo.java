package prototype.improves;

public class DeepCopyRegistryDemo {
    public static void main(String[] args) {
        // 1. (程序启动时) 加载一次昂贵的缓存
        ShapeCache.loadCache();

        System.out.println("\n--- Client requests shapes ---");

        // 2. 客户端 1 需要一个圆形
        Circle shape1 = (Circle) ShapeCache.getShape("circle");
        shape1.draw();

        // 3. 客户端 2 需要另一个圆形
        Circle shape2 = (Circle) ShapeCache.getShape("circle");
        shape2.draw();

        // 4. 验证：shape1 和 shape2 是不是同一个对象？
        System.out.println("\n--- Verification (Shape) ---");
        System.out.println("Shape1 hashCode: " + shape1.hashCode());
        System.out.println("Shape2 hashCode: " + shape2.hashCode());
        if (shape1 != shape2) {
            System.out.println("Success: Shape1 and Shape2 are different instances.");
        } else {
            System.out.println("Error: Shape1 and Shape2 are the SAME instance!");
        }

        // 5. 关键验证：它们内部的 Point 对象是不是同一个？
        System.out.println("\n--- Verification (Deep Copy) ---");
        System.out.println("Shape1's Center: " + shape1.getCenter());
        System.out.println("Shape2's Center: " + shape2.getCenter());

        if (shape1.getCenter() != shape2.getCenter()) {
            System.out.println("Success: Their 'center' Points are different instances (Deep Copy worked!)");
        } else {
            System.out.println("Error: They share the SAME 'center' Point (Shallow Copy failed!)");
        }

        // 6. 演示：修改 shape1 的坐标，看是否影响 shape2
        shape1.getCenter().setX(999);
        System.out.println("\n--- After modifying Shape1's center ---");
        System.out.println("Shape1: ");
        shape1.draw();
        System.out.println("Shape2: ");
        shape2.draw(); // 应该不受影响
    }
}
