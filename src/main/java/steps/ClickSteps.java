package steps;

import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import io.qameta.atlas.webdriver.AtlasWebElement;
import pages.html_elements.Button;
import pages.html_elements.Text;
import ru.lanit.at.pages.element.UIElement;

public class ClickSteps extends BaseSteps {
    @Если("нажать на элемент {element}")
    public void clickOnElem(UIElement element) {
        element.click();
    }

    @И("нажать на {type} с текстом {string}")
    public void clickButtonWithText(Class<? extends UIElement> type, String text) {
        getUIElement(type, text).click();
    }

    @И("нажать на элемент с текстом {string}")
    public void findAndExecute(String elementText) {
        getUIElement(Text.class, elementText).click();
    }

    @И("нажать {type} {string}")
    @Если("нажать на {type} {string}")
    public void clickElementByName(Class<? extends AtlasWebElement> type, String name) {
        getElementByName(name, type).click();
    }

    // Deprecated: использовать формулировку "нажать на элемент с названием {string}"
    @И("нажать на элемент {string}")
    @Если("нажать на элемент с названием {string}")
    public void clickOnElement(String elementName) {
        getElementByName(elementName, UIElement.class).click();
    }

    @И("^нажать с помощью JS на кнопку с текстом '(.*)'$")
    public void clickJsButtonWithText(String param) {
        UIElement uiElement = getUIElement(Button.class, param);
        uiElement.make().jsClickOn(uiElement);
    }
}
