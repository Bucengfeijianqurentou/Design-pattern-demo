package FactoryMethod.ConcreteCreator;

import FactoryMethod.Car;
import FactoryMethod.ConcreteProduct.ElectricCar;
import FactoryMethod.Creator.CarFactory;

// 具体创建者类：电动汽车工厂
public class ElectricCarFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new ElectricCar();  // 创建电动汽车
    }
}
