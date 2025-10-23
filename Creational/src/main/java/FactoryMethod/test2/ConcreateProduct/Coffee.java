package FactoryMethod.test2.ConcreateProduct;

import FactoryMethod.test2.Beverage;

//具体饮料：咖啡
public class Coffee implements Beverage {
    @Override
    public void prepare() {
        System.out.println("准备咖啡");
    }

    @Override
    public void serve() {
        System.out.println("提供咖啡");
    }
}
