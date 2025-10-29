package prototype.old;

public class DeepCopyDemo {
    public static void main(String[] args) {
        // 1. 创建原型羊 "Dolly"
        DeepCopySheep dolly = new DeepCopySheep("Dolly", 3);
        dolly.getLambs().add("Bonnie");

        System.out.println("--- Original Dolly ---");
        System.out.println(dolly);

        // 2. 克隆 Dolly 得到 Saily
        DeepCopySheep saily = (DeepCopySheep) dolly.clone();
        saily.setName("Saily");

        System.out.println("\n--- Cloned Saily (Deep) ---");
        System.out.println(saily);

        // 3. 我们给 Saily 添加一只小羊
        System.out.println("\n--- Adding lamb to Saily... ---");
        saily.getLambs().add("Molly");

        // 4. 检查 Saily 和 Dolly
        System.out.println("\n--- After modification ---");
        System.out.println("Saily: " + saily);
        System.out.println("Dolly: " + dolly); // 安全！Dolly 没有被修改

        // 5. 验证
        if (dolly.getLambs() != saily.getLambs()) {
            System.out.println("\nSuccess: Both sheep have DIFFERENT List objects!");
        }
    }
}
