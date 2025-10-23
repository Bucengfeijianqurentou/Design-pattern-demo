package FactoryMethod;

import FactoryMethod.ConcreteCreator.ElectricCarFactory;
import FactoryMethod.ConcreteCreator.FuelCarFactory;
import FactoryMethod.ConcreteCreator.HybridCarFactory;
import FactoryMethod.Creator.CarFactory;

public class Client {
    public static void main(String[] args) {
        // 创建一个电动汽车工厂并生成电动汽车
        CarFactory electricCarFactory = new ElectricCarFactory();
        Car electricCar = electricCarFactory.createCar();
        electricCar.drive();  // 输出：Driving an electric car!

        // 创建一个燃油汽车工厂并生成燃油汽车
        CarFactory fuelCarFactory = new FuelCarFactory();
        Car fuelCar = fuelCarFactory.createCar();
        fuelCar.drive();  // 输出：Driving a fuel car!

        // 创建一个混合汽车工厂并生成混合汽车
        CarFactory hybridCarFactory = new HybridCarFactory();
        Car car = hybridCarFactory.createCar();
        car.drive();
    }
}
