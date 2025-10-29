package prototype.improves;

// 1. Point 类，它自己也必须实现 Cloneable
public class Point implements Cloneable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public int getX() { return this.x; }

    @Override
    public String toString() {
        return "Point(x=" + x + ", y=" + y + ", hashCode=" + this.hashCode() + ")";
    }

    // Point 类的 clone 方法（它没有引用类型，浅拷贝即可）
    @Override
    public Object clone() {
        System.out.println("Cloning Point " + this.hashCode() + "...");
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
