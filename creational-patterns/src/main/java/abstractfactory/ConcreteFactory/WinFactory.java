package abstractfactory.ConcreteFactory;

import abstractfactory.AbstractFactory.GUIFactory;
import abstractfactory.AbstractProduct.Button;
import abstractfactory.AbstractProduct.Checkbox;
import abstractfactory.ConcreteProduct.WinButton;
import abstractfactory.ConcreteProduct.WinCheckbox;

// 具体工厂：Windows 工厂
public class WinFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}
