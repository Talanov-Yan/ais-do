package steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import pages.html_elements.CheckBox;
import pages.html_elements.RadioButton;

public class RadioButtonSteps extends BaseSteps {
    @И("выбрать радиокнопку")
    public void selectRadioButton() {
        RadioButton radioButton = getUIElement(RadioButton.class);
        radioButton.select();
    }

    @То("радиокнопка выбрана")
    public void checkRadioButtonSelected() {
        RadioButton radioButton = getUIElement(RadioButton.class);
        boolean isSelected = radioButton.isSelected();
        softAssert().assertTrue(isSelected, "Ожидалось что радиокнопка  выбрана.");
    }

    @То("^радиокнопка не выбрана")
    public void checkRadioButtonNotSelected() {
        RadioButton radioButton = getUIElement(RadioButton.class);
        boolean isSelected = radioButton.isSelected();
        softAssert().assertFalse(isSelected, "Ожидалось что радиокнопка  не выбрана.");
    }

    @И("активировать радиокнопку c текстом {string}")
    public void selectRadioButtonWithLabel(String text) {
        RadioButton radioButton = getUIElement(RadioButton.class, text);
        radioButton.select();
    }
}
