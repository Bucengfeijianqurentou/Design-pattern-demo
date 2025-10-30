package decorator.ConcreteComponent;

import decorator.Component.Coffee;

// 2. 具体组件 (ConcreteComponent) - 基础咖啡
// 我们定义一个“简单浓缩咖啡”
public class SimpleEspresso implements Coffee {

    @Override
    public double getCost() {
        return 10.0; // 一杯浓缩咖啡 10 元
    }

    @Override
    public String getDescription() {
        return "浓缩咖啡";
    }
}
