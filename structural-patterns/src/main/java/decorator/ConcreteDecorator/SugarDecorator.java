package decorator.ConcreteDecorator;

import decorator.Component.Coffee;
import decorator.Decorator.CoffeeDecorator;

// 4b. 具体装饰器 (ConcreteDecorator) - 糖
public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    // --- 重点：添加新功能 ---

    @Override
    public double getCost() {
        // 加糖 2 元
        double sugarCost = 2.0;
        return super.getCost() + sugarCost;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", 加糖";
    }
}
