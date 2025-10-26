package factory.test2.ConcreateProduct;

import factory.test2.Beverage;
// 具体产品类：茶
public class Tea implements Beverage {
    @Override
    public void prepare() {
        System.out.println("Prepare Tea");
    }

    @Override
    public void serve() {
        System.out.println("Serve Tea");
    }
}
