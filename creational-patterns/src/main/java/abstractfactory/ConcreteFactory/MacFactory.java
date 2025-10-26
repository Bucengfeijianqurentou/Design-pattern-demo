package abstractfactory.ConcreteFactory;

import abstractfactory.AbstractFactory.GUIFactory;
import abstractfactory.AbstractProduct.Button;
import abstractfactory.AbstractProduct.Checkbox;
import abstractfactory.ConcreteProduct.MacButton;
import abstractfactory.ConcreteProduct.MacCheckbox;

// 具体工厂：macOS 工厂
public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
