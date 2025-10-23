package FactoryMethod.test2;

import FactoryMethod.test2.ConcreteCreator.CoffeeFactory;
import FactoryMethod.test2.ConcreteCreator.TeaFactory;
import FactoryMethod.test2.Creator.BeverageFactory;

public class Client {
    /**
     * 程序入口函数，演示饮料制作工厂模式
     * 通过不同的工厂创建对应的饮料对象，并执行准备和供应操作
     * @param args 命令行参数数组
     */
    public static void main(String[] args) {
        // 创建咖啡工厂并制作咖啡
        BeverageFactory coffeeFactory = new CoffeeFactory();
        Beverage coffee = coffeeFactory.createBeverage();
        coffee.prepare();
        coffee.serve();

        // 创建茶工厂并制作茶
        BeverageFactory teaFactory = new TeaFactory();
        Beverage tea = teaFactory.createBeverage();
        tea.prepare();
        tea.serve();


    }

}
