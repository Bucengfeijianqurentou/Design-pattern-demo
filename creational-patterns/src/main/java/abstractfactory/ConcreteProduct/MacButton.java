package abstractfactory.ConcreteProduct;

import abstractfactory.AbstractProduct.Button;

// 具体产品：macOS 风格的按钮
public class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in macOS style.");
    }
}