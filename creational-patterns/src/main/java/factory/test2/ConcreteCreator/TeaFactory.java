package factory.test2.ConcreteCreator;

import factory.test2.Beverage;
import factory.test2.ConcreateProduct.Tea;
import factory.test2.Creator.BeverageFactory;
// 具体创建者类：茶工厂
public class TeaFactory extends BeverageFactory {
    @Override
    public Beverage createBeverage() {
        return new Tea();
    }
}
