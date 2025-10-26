package abstractfactory.ConcreteProduct;

import abstractfactory.AbstractProduct.Checkbox;

public class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a checkbox in macOS style.");
    }
}