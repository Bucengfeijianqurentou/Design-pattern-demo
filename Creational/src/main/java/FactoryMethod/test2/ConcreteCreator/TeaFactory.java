package FactoryMethod.test2.ConcreteCreator;

import FactoryMethod.test2.Beverage;
import FactoryMethod.test2.ConcreateProduct.Tea;
import FactoryMethod.test2.Creator.BeverageFactory;
// 具体创建者类：茶工厂
public class TeaFactory extends BeverageFactory {
    @Override
    public Beverage createBeverage() {
        return new Tea();
    }
}
