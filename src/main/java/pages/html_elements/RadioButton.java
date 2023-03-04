package pages.html_elements;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.element.UIElement;

import static pages.XPLib.r;

@Title("РадиоКнопка")
public interface RadioButton extends UIElement {


    default void select() {
        this.click();
    }


    interface WithRadioButton extends UIElement {
        @FindBy(".//input[@type='radio']")
        RadioButton radioButton();

        @FindBy(r + "label[contains(normalize-space(.), '{{ text }}')]//input[@type='radio']")
        RadioButton radioButtonWithLabel(@Param(value = "text") String text);
    }
}
