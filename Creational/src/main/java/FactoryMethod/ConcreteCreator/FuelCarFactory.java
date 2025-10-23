package FactoryMethod.ConcreteCreator;

import FactoryMethod.Car;
import FactoryMethod.ConcreteProduct.FuelCar;
import FactoryMethod.Creator.CarFactory;

// 具体创建者类：燃油汽车工厂
public class FuelCarFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new FuelCar();  // 创建燃油汽车
    }
}
