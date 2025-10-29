package prototype.old;

import java.util.ArrayList;
import java.util.List;

// 1. 必须实现 Cloneable 接口
public class Sheep implements Cloneable {
    private String name;
    private int age;

    // 关键：这是一个引用类型
    private List<String> lambs; // 小羊的名字

    public Sheep(String name, int age) {
        this.name = name;
        this.age = age;
        this.lambs = new ArrayList<>();
        // 假设初始化很慢...
        System.out.println("Sheep '" + name + "' created (Expensive creation)");
    }

    // Getters and Setters
    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    public void setLambs(List<String> lambs) { this.lambs = lambs; }
    public List<String> getLambs() { return this.lambs; }

    @Override
    public String toString() {
        return "Sheep [name=" + name + ", age=" + age + ", lambs=" + lambs + ", lambs_hashCode=" + lambs.hashCode() + "]";
    }

    // 2. 重写 clone() 方法，并改为 public
    @Override
    public Object clone() {
        System.out.println("Cloning sheep '" + this.name + "'...");
        try {
            // 3. 调用 super.clone()，这就是在执行浅拷贝
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // 理论上，因为我们实现了 Cloneable，这里永远不会被触发
            e.printStackTrace();
            return null;
        }
    }
}