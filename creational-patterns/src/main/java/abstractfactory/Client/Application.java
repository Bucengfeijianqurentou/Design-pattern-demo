package abstractfactory.Client;

import abstractfactory.AbstractFactory.GUIFactory;
import abstractfactory.AbstractProduct.Button;
import abstractfactory.AbstractProduct.Checkbox;
import abstractfactory.ConcreteFactory.MacFactory;
import abstractfactory.ConcreteFactory.WinFactory;

// 客户端应用
public class Application {
    private Button button;
    private Checkbox checkbox;

    // 构造函数接收一个抽象工厂
    public Application(GUIFactory factory) {
        // 客户端不关心是 WinFactory 还是 MacFactory
        // 它只管调用 create 方法
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paintUI() {
        button.paint();
        checkbox.paint();
    }
}

// 客户端配置和运行
class ClientDemo {

    // 根据配置（例如操作系统名称）来决定使用哪个工厂
    private static Application configureApplication() {
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println(osName);

        // 假设我们简单地根据 OS 名称判断
        if (osName.contains("win")) {
            factory = new WinFactory();
        } else if (osName.contains("mac")) {
            factory = new MacFactory();
        } else {
            // 默认或抛出异常
            System.out.println("Unknown OS, using Windows factory as default.");
            factory = new WinFactory();
        }

        return new Application(factory);
    }

    public static void main(String[] args) {
        // 客户端在运行时动态获取具体工厂
        Application app = configureApplication();

        // 客户端执行操作
        app.paintUI();

        // 如果在 Windows 上运行，输出：
        // Rendering a button in Windows style.
        // Rendering a checkbox in Windows style.

        // 如果在 macOS 上运行，输出：
        // Rendering a button in macOS style.
        // Rendering a checkbox in macOS style.
    }
}