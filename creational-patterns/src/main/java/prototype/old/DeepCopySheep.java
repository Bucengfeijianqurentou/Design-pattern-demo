package prototype.old;

import java.util.ArrayList;
import java.util.List;

// (Sheep 类的其他部分和上面一样)
public class DeepCopySheep implements Cloneable {

    private String name;
    private int age;
    private List<String> lambs;

    public DeepCopySheep(String name, int age) {
        this.name = name;
        this.age = age;
        this.lambs = new ArrayList<>();
        System.out.println("DeepCopySheep '" + name + "' created (Expensive creation)");
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    public void setLambs(List<String> lambs) { this.lambs = lambs; }
    public List<String> getLambs() { return this.lambs; }

    @Override
    public String toString() {
        return "DeepCopySheep [name=" + name + ", age=" + age + ", lambs=" + lambs + ", lambs_hashCode=" + lambs.hashCode() + "]";
    }

    // --- 关键：实现深拷贝 ---
    @Override
    public Object clone() {
        System.out.println("Deep cloning sheep '" + this.name + "'...");
        try {
            // 1. 先执行浅拷贝，得到一个“半成品”
            DeepCopySheep clonedSheep = (DeepCopySheep) super.clone();

            // 2. 手动处理引用类型！
            // 我们需要为克隆羊创建一个全新的 List
            clonedSheep.lambs = new ArrayList<>(this.lambs);
            // (注意: 这里可行是因为 String 是不可变的。
            // 如果 List<T> 中的 T 是可变对象，比如 List<Location>，
            // 你必须遍历 List，并挨个克隆 T！)

            return clonedSheep;

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
