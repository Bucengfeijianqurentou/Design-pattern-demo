package prototype.improves;

// 4. Rectangle 类，包含两个引用类型 Point
public class Rectangle implements Shape {

    private Point topLeft; // 引用类型 1
    private Point bottomRight; // 引用类型 2

    public Rectangle(Point topLeft, Point bottomRight) {
        System.out.println("Creating Rectangle (Expensive)...");
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    // Getter for verification
    public Point getTopLeft() { return this.topLeft; }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle from " + topLeft + " to " + bottomRight);
    }

    // --- 关键：Rectangle 的深拷贝实现 ---
    @Override
    public Object clone() {
        System.out.println("Deep Cloning Rectangle...");
        try {
            // 1. 先浅拷贝 Rectangle 对象本身
            Rectangle clonedRectangle = (Rectangle) super.clone();

            // 2. 手动克隆所有内部的引用类型
            clonedRectangle.topLeft = (Point) this.topLeft.clone();
            clonedRectangle.bottomRight = (Point) this.bottomRight.clone();

            return clonedRectangle;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
