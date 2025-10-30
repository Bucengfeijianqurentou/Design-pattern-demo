package decorator.ConcreteDecorator;

import decorator.Component.DataService;
import decorator.Decorator.DataServiceDecorator;

import java.time.LocalDateTime;

// 4b. 具体装饰器 - 日志功能
public class LoggingDataServiceDecorator extends DataServiceDecorator {

    public LoggingDataServiceDecorator(DataService service) {
        super(service);
    }

    // --- 重点：重写方法，添加新功能 ---
    @Override
    public String getData(String id) {
        // 1. 调用前：打印日志
        System.out.println("--- [日志] 开始请求数据... ID: " + id + ", 时间: " + LocalDateTime.now());

        // 2. 调用原始服务
        String data = super.getData(id);

        // 3. 调用后：打印日志
        System.out.println("--- [日志] 数据请求完成。ID: " + id + ", 时间: " + LocalDateTime.now());

        return data;
    }
}
