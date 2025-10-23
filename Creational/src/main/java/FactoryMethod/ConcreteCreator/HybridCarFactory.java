package FactoryMethod.ConcreteCreator;

import FactoryMethod.Car;
import FactoryMethod.ConcreteProduct.HybridCar;
import FactoryMethod.Creator.CarFactory;

public class HybridCarFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new HybridCar();
    }
}
