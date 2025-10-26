package factory.ConcreteCreator;

import factory.Car;
import factory.ConcreteProduct.ElectricCar;
import factory.Creator.CarFactory;

// 具体创建者类：电动汽车工厂
public class ElectricCarFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new ElectricCar();  // 创建电动汽车
    }
}
