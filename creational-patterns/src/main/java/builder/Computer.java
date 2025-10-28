package builder;

// 1. 产品类：Computer
public class Computer {

    // 关键：所有字段都是 final，确保不可变性
    private final String cpu;
    private final String ram;
    private final String ssd;

    // 可选字段
    private final String gpu;
    private final String powerSupply;

    // 关键：构造函数是 private 的！
    // 它只从 Builder 中获取数据
    private Computer(Builder builder) {
        this.cpu = builder.cpu; // 必选
        this.ram = builder.ram; // 必选
        this.ssd = builder.ssd; // 必选

        this.gpu = builder.gpu; // 可选
        this.powerSupply = builder.powerSupply; // 可选
    }

    @Override
    public String toString() {
        return "Computer [cpu=" + cpu + ", ram=" + ram + ", ssd=" + ssd +
                ", gpu=" + (gpu == null ? "N/A" : gpu) +
                ", powerSupply=" + (powerSupply == null ? "N/A" : powerSupply) + "]";
    }

    // 省略 getters...

    // ... 马上在这里添加 Builder ...
    // 2. 关键：定义 public static 内部类 Builder
    public static class Builder {

        // Builder 类中包含和 Computer 完全一样的字段
        // 但它们不是 final 的，因为需要被设置

        // 必选字段
        private final String cpu;
        private final String ram;
        private final String ssd;

        // 可选字段
        private String gpu;
        private String powerSupply;

        // 关键：Builder 的构造函数只接收“必选”参数
        public Builder(String cpu, String ram, String ssd) {
            this.cpu = cpu;
            this.ram = ram;
            this.ssd = ssd;
        }

        // 关键：为“可选”参数提供链式 set 方法
        // 返回 this (Builder 自己)
        public Builder withGpu(String gpu) {
            this.gpu = gpu;
            return this; // 返回当前 Builder 实例
        }

        public Builder withPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this; // 返回当前 Builder 实例
        }

        // 关键：最后一步，调用 build() 方法
        // 它会调用 Computer 的私有构造函数
        public Computer build() {
            // 在这里可以添加一些构建前的校验逻辑
            if (cpu == null || ram == null || ssd == null) {
                throw new IllegalStateException("CPU, RAM, and SSD are required!");
            }

            return new Computer(this); // 'this' 就是 Builder 实例
        }
    }
}
