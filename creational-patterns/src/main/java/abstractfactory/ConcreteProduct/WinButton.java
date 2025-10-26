package abstractfactory.ConcreteProduct;

import abstractfactory.AbstractProduct.Button;
// 具体产品：Windows 风格的按钮
public class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a button in Windows style.");
    }
}
