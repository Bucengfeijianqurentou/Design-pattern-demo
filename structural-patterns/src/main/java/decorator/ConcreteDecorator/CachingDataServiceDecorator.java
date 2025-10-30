package decorator.ConcreteDecorator;

import decorator.Component.DataService;
import decorator.Decorator.DataServiceDecorator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// 4a. 具体装饰器 - 缓存功能
public class CachingDataServiceDecorator extends DataServiceDecorator {

    // 一个简单的内存缓存
    private Map<String, String> cache = new ConcurrentHashMap<>();

    public CachingDataServiceDecorator(DataService service) {
        super(service);
    }

    // --- 重点：重写方法，添加新功能 ---
    @Override
    public String getData(String id) {
        // 1. 检查缓存
        if (cache.containsKey(id)) {
            System.out.println("--- [缓存命中] 正在从缓存获取... ID: " + id);
            return cache.get(id);
        }

        // 2. 缓存未命中：调用原始服务（super.getData）
        System.out.println("--- [缓存未命中] ");
        String data = super.getData(id); // 委托给被包装的对象（可能是数据库，也可能是另一层装饰器）

        // 3. 将结果存入缓存
        cache.put(id, data);
        return data;
    }
}
