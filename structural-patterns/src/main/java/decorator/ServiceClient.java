package decorator;

import decorator.Component.DataService;
import decorator.ConcreteComponent.DatabaseDataService;
import decorator.ConcreteDecorator.CachingDataServiceDecorator;
import decorator.ConcreteDecorator.LoggingDataServiceDecorator;

public class ServiceClient {
    public static void main(String[] args) {

        // 1. 创建我们的“核心服务” (被装饰者)
        DataService myService = new DatabaseDataService();

        // 2. 动态组合：我们想要缓存和日志功能
        //    顺序很重要！
        //    我们希望日志能记录“包括缓存操作在内”的所有行为

        // a. 先用“缓存”包装它
        myService = new CachingDataServiceDecorator(myService);

        // b. 再用“日志”包装“已经带缓存的服务”
        myService = new LoggingDataServiceDecorator(myService);

        // 现在的 myService 是一个“套娃”：
        // Log -> Cache -> Database

        System.out.println("=== 第一次请求 (ID: 123) ===");
        // 调用会从最外层（Log）开始
        System.out.println("最终结果: " + myService.getData("123"));

        System.out.println("\n=== 第二次请求 (ID: 123) ===");
        // 再次调用
        System.out.println("最终结果: " + myService.getData("123"));

        System.out.println("\n=== 第三次请求 (ID: 456) ===");
        // 请求一个新数据
        System.out.println("最终结果: " + myService.getData("456"));
    }
}
