package decorator.Component;

// 1. 抽象组件 (Component)
public interface Coffee {
    /**
     * 获取价格
     * @return 价格
     */
    double getCost();

    /**
     * 获取描述
     * @return 描述
     */
    String getDescription();
}
