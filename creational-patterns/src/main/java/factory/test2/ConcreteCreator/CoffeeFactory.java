package factory.test2.ConcreteCreator;

import factory.test2.Beverage;
import factory.test2.ConcreateProduct.Coffee;
import factory.test2.Creator.BeverageFactory;
//具体创建者类：咖啡工厂
public class CoffeeFactory extends BeverageFactory {
    @Override
    public Beverage createBeverage() {
        return new Coffee();
    }
}
