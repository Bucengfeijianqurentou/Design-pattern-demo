package decorator;

import decorator.Component.Coffee;
import decorator.ConcreteComponent.SimpleEspresso;
import decorator.ConcreteDecorator.MilkDecorator;
import decorator.ConcreteDecorator.SugarDecorator;

public class CoffeeShopClient {
    public static void main(String[] args) {

        // 1. 点一杯最简单的浓缩咖啡
        Coffee basicCoffee = new SimpleEspresso();
        System.out.println("订单 1: " + basicCoffee.getDescription());
        System.out.println("价格: " + basicCoffee.getCost());
        System.out.println("--------------------");

        // 2. 点一杯“加了牛奶”的浓缩咖啡
        // a. 先拿到一杯简单咖啡
        Coffee coffeeWithMilk = new SimpleEspresso();
        // b. 用 MilkDecorator 包装它
        coffeeWithMilk = new MilkDecorator(coffeeWithMilk);

        System.out.println("订单 2: " + coffeeWithMilk.getDescription());
        System.out.println("价格: " + coffeeWithMilk.getCost());
        System.out.println("--------------------");

        // 3. 点一杯“加了牛奶”又“加了糖”的浓缩咖啡
        //    这就是“套娃”的开始！
        Coffee coffeeWithMilkAndSugar = new SimpleEspresso(); // a. 基础咖啡 (10元, "浓缩咖啡")
        coffeeWithMilkAndSugar = new MilkDecorator(coffeeWithMilkAndSugar); // b. 包装牛奶 (15元, "...加牛奶")
        coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilkAndSugar); // c. 包装糖   (17元, "...加牛奶, 加糖")

        System.out.println("订单 3: " + coffeeWithMilkAndSugar.getDescription());
        System.out.println("价格: " + coffeeWithMilkAndSugar.getCost());
        System.out.println("--------------------");

        // 4. 点一杯“加了双份牛奶”又“加了糖”的浓缩咖啡
        Coffee coffeeWithDoubleMilkAndSugar = new SimpleEspresso();
        coffeeWithDoubleMilkAndSugar = new MilkDecorator(coffeeWithDoubleMilkAndSugar); // 加第一份牛奶
        coffeeWithDoubleMilkAndSugar = new MilkDecorator(coffeeWithDoubleMilkAndSugar); // 加第二份牛奶！
        coffeeWithDoubleMilkAndSugar = new SugarDecorator(coffeeWithDoubleMilkAndSugar);

        System.out.println("订单 4: " + coffeeWithDoubleMilkAndSugar.getDescription());
        System.out.println("价格: " + coffeeWithDoubleMilkAndSugar.getCost());


        //5. 点一杯“加了牛奶”又“加了糖”又“加了糖”的浓缩咖啡
        SimpleEspresso coffee = new SimpleEspresso();
        SugarDecorator sugarDecorator = new SugarDecorator(new SugarDecorator(new MilkDecorator(coffee)));
        System.out.println("sugarDecorator.getDescription() = " + sugarDecorator.getDescription());
        System.out.println("sugarDecorator.getCost() = " + sugarDecorator.getCost());
    }
}
