package builder;

public class BuildComputerClient {

    public static void main(String[] args) {

        // 场景 1：构建一台顶配游戏电脑（所有参数都设置）
        // 可读性极强！
        Computer gamingPC = new Computer.Builder("Intel i9", "64GB", "2TB NVMe SSD")
                .withGpu("NVIDIA RTX 4090")
                .withPowerSupply("1200W")
                .build();

        System.out.println("Gaming PC Config: " + gamingPC);


        // 场景 2：构建一台办公电脑（只设置必选参数，和部分可选参数）
        Computer officePC = new Computer.Builder("Intel i5", "16GB", "1TB SATA SSD")
                .withPowerSupply("500W")
                // .withGpu() // 不调用这个方法，GPU 就会是默认值 (null)
                .build();

        System.out.println("Office PC Config: " + officePC);


        // 场景 3：尝试非法构建（比如不给必选参数）
        // 如果 Builder 构造函数中没有必选参数，我们可以在 build() 方法中校验
        // (在我们的例子中，构造函数强制要求了必选参数，所以编译不通过)

        // 比如，如果我们把必选参数也改成 withXxx()
        // 并在 build() 中校验，就可以抛出异常
        // Computer brokenPC = new Computer.Builder().withRam("16GB").build();
        // ^^^ 这会抛出我们定义的 IllegalStateException
    }
}