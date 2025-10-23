package FactoryMethod.Creator;

import FactoryMethod.Car;
// 创建者类  一个抽象类，它声明了工厂方法的签名。
public abstract class CarFactory {
    public abstract Car createCar();  // 工厂方法，子类会实现此方法来创建具体产品
}
