package prototype.old;

import java.util.ArrayList;
import java.util.List;

public class SheepWithCopyConstructor {
    private String name;
    private int age;
    private List<String> lambs;

    // 普通构造函数
    public SheepWithCopyConstructor(String name, int age) {
        this.name = name;
        this.age = age;
        this.lambs = new ArrayList<>();
        System.out.println("Sheep '" + name + "' created (Expensive original)");
    }

    // --- 关键：拷贝构造函数 ---
    public SheepWithCopyConstructor(SheepWithCopyConstructor other) {
        System.out.println("Copying sheep '" + other.name + "' via Copy Constructor...");
        this.name = other.name;
        this.age = other.age;

        // 我们在这里实现“深拷贝”逻辑
        this.lambs = new ArrayList<>(other.lambs);
    }

    public void setName(String name) { this.name = name; }
    public String getName() { return this.name; }
    public void setLambs(List<String> lambs) { this.lambs = lambs; }
    public List<String> getLambs() { return this.lambs; }

    @Override
    public String toString() {
        return "DeepCopySheep [name=" + name + ", age=" + age + ", lambs=" + lambs + ", lambs_hashCode=" + lambs.hashCode() + "]";
    }
}

// --- 客户端使用 ---
class CopyConstructorDemo {
    public static void main(String[] args) {
        SheepWithCopyConstructor dolly = new SheepWithCopyConstructor("Dolly", 3);
        dolly.getLambs().add("Bonnie");

        // 使用拷贝构造函数
        SheepWithCopyConstructor saily = new SheepWithCopyConstructor(dolly);
        saily.setName("Saily");

        saily.getLambs().add("Molly");

        System.out.println("Dolly: " + dolly.getLambs());
        System.out.println("Saily: " + saily.getLambs());
    }
}
