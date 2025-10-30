package decorator.ConcreteDecorator;

import decorator.Component.Coffee;
import decorator.Decorator.CoffeeDecorator;

// 4a. 具体装饰器 (ConcreteDecorator) - 牛奶
public class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        // 必须调用父类构造函数，把“被包装的咖啡”传进去
        super(coffee);
    }

    // --- 重点：添加新功能 ---

    @Override
    public double getCost() {
        // 在“被包装的咖啡”的价格基础上，加上牛奶的价格
        double milkCost = 5.0;
        return super.getCost() + milkCost; // super.getCost() 就是在调用 wrappedCoffee.getCost()
    }

    @Override
    public String getDescription() {
        // 在“被包装的咖啡”的描述基础上，加上“牛奶”
        return super.getDescription() + ", 加牛奶";
    }
}
