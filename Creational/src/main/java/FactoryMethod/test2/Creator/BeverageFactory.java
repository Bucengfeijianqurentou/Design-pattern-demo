package FactoryMethod.test2.Creator;

import FactoryMethod.test2.Beverage;
// 抽象创建者类
public abstract class BeverageFactory {
    public abstract Beverage createBeverage();
}
