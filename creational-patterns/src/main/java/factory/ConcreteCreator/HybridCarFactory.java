package factory.ConcreteCreator;

import factory.Car;
import factory.ConcreteProduct.HybridCar;
import factory.Creator.CarFactory;

public class HybridCarFactory extends CarFactory {
    @Override
    public Car createCar() {
        return new HybridCar();
    }
}
