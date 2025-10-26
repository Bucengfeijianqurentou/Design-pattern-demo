package abstractfactory.AbstractFactory;

import abstractfactory.AbstractProduct.Button;
import abstractfactory.AbstractProduct.Checkbox;

// 抽象工厂：GUI 工厂接口
public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
