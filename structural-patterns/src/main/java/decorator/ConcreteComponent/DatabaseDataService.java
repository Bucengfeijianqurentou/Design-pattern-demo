package decorator.ConcreteComponent;

import decorator.Component.DataService;

// 2. 具体组件 (ConcreteComponent)
// 原始的、缓慢的数据库服务
public class DatabaseDataService implements DataService {

    @Override
    public String getData(String id) {
        // 模拟缓慢的数据库 I/O 操作
        try {
            System.out.println(">>> 正在从数据库查询... ID: " + id);
            Thread.sleep(2000); // 模拟 2 秒钟的延迟
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 返回查询到的数据
        return "数据库的宝贵数据: " + id;
    }
}
