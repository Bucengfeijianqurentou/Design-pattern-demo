package FactoryMethod.ConcreteProduct;

import FactoryMethod.Car;
// 具体产品类：燃油汽车
public class FuelCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a fuel car!");
    }
}
