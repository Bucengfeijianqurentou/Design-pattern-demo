package abstractfactory.ConcreteProduct;

import abstractfactory.AbstractProduct.Checkbox;

// 具体产品：Windows 风格的复选框
public class WinCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in Windows style.");
    }
}
