package decorator.Component;

// 1. 抽象组件 (Component)
// 定义了所有数据服务都必须实现的功能
public interface DataService {
    /**
     * 根据 ID 获取数据
     * @param id 数据 ID
     * @return 数据内容
     */
    String getData(String id);
}
