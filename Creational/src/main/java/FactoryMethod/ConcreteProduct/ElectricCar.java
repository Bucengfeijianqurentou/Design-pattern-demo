package FactoryMethod.ConcreteProduct;

import FactoryMethod.Car;

// 具体产品类：电动汽车
public class ElectricCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving an electric car!");
    }
}
