package decorator.Decorator;

// 3. 抽象装饰器 (Decorator)
// 它必须实现 Coffee 接口，这样才能被包装
// 它必须持有 Coffee 引用，这样才能包装别人

import decorator.Component.Coffee;

public abstract class CoffeeDecorator implements Coffee {

    // 关键：持有一个被装饰者（Component）的引用
    protected Coffee wrappedCoffee;

    // 关键：通过构造函数，将被装饰者传递进来
    public CoffeeDecorator(Coffee coffee) {
        this.wrappedCoffee = coffee;
    }

    // 关键：默认实现，将请求“委托”给被包装的对象
    // 装饰器本身并不“修改”原有功能，只是“转交”
    @Override
    public double getCost() {
        return wrappedCoffee.getCost(); // 委托！
    }

    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription(); // 委托！
    }
}
