package FactoryMethod.ConcreteProduct;

import FactoryMethod.Car;
//具体的产品：混动车
public class HybridCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a Hybrid car!");
    }
}
