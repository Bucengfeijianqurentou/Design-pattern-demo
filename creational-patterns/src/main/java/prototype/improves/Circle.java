package prototype.improves;

// 3. Circle 类，包含一个引用类型 Point
public class Circle implements Shape {

    private Point center; // 引用类型！
    private int radius;

    public Circle(Point center, int radius) {
        System.out.println("Creating Circle (Expensive)...");
        this.center = center;
        this.radius = radius;
    }

    // Getter for verification
    public Point getCenter() { return this.center; }

    @Override
    public void draw() {
        System.out.println("Drawing Circle at " + center + " with radius " + radius);
    }

    // --- 关键：Circle 的深拷贝实现 ---
    @Override
    public Object clone() {
        System.out.println("Deep Cloning Circle...");
        try {
            // 1. 先浅拷贝 Circle 对象本身
            Circle clonedCircle = (Circle) super.clone();

            // 2. 重点！手动克隆 Circle 内部的引用类型
            // 必须调用 center 自己的 clone() 方法
            clonedCircle.center = (Point) this.center.clone();

            return clonedCircle;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
