package decorator.Decorator;

import decorator.Component.DataService;

// 3. 抽象装饰器 (Decorator)
public abstract class DataServiceDecorator implements DataService {

    // 持有被包装的“数据服务”
    protected DataService wrappedService;

    public DataServiceDecorator(DataService service) {
        this.wrappedService = service;
    }

    // 默认实现：委托给被包装的对象
    @Override
    public String getData(String id) {
        return wrappedService.getData(id);
    }
}
