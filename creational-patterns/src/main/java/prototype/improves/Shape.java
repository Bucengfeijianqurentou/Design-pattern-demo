package prototype.improves;

// 2. Shape 接口
public interface Shape extends Cloneable {
    void draw();
    Object clone(); // 强制子类实现 clone
}
