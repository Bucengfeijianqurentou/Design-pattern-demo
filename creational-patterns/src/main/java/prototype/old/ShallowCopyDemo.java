package prototype.old;

public class ShallowCopyDemo {
    public static void main(String[] args) {
        // 1. 创建原型羊 "Dolly"
        Sheep dolly = new Sheep("Dolly", 3);
        dolly.getLambs().add("Bonnie");

        System.out.println("--- Original Dolly ---");
        System.out.println(dolly);

        // 2. 克隆 Dolly 得到 Saily
        Sheep saily = (Sheep) dolly.clone();
        saily.setName("Saily"); // 修改克隆羊的名字

        System.out.println("\n--- Cloned Saily (Shallow) ---");
        System.out.println(saily);

        // 3. 灾难发生：我们给 Saily 添加一只小羊
        System.out.println("\n--- Adding lamb to Saily... ---");
        saily.getLambs().add("Molly");

        // 4. 检查 Saily 和 Dolly
        System.out.println("\n--- After modification ---");
        System.out.println("Saily: " + saily);
        System.out.println("Dolly: " + dolly); // 完蛋！Dolly 也被修改了！

        // 5. 验证
        if (dolly.getLambs() == saily.getLambs()) {
            System.out.println("\nError: Both sheep share the SAME List object!");
        }
    }
}
