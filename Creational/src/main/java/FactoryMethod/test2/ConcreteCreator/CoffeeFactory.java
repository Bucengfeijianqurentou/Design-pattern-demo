package FactoryMethod.test2.ConcreteCreator;

import FactoryMethod.test2.Beverage;
import FactoryMethod.test2.ConcreateProduct.Coffee;
import FactoryMethod.test2.Creator.BeverageFactory;
//具体创建者类：咖啡工厂
public class CoffeeFactory extends BeverageFactory {
    @Override
    public Beverage createBeverage() {
        return new Coffee();
    }
}
