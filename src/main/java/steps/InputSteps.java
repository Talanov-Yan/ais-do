package steps;

import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.Keys;
import pages.aisdo.blocks.ConfirmModalBlock;
import pages.html_elements.Input;
import pages.html_elements.Text;
import ru.lanit.at.pages.element.UIElement;
import utils.data.helpers.DataRandomGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public class InputSteps extends BaseSteps {
    @И("ввести в поле {element} значение {string}")
    public void typeIntoInput(UIElement element, String text) {
        element.sendKeys(text);
    }

    @И("ввести в поля ввода значения")
    public void typeIntoInput(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        for (Map<String, String> l : list) {
            String[] fieldName = {l.get("Название поля")};
            getUIElement(Input.class, fieldName).sendKeys(l.get("Значение"));
        }
    }

    @И("ввести в поле ввода значение {string}")
    public void typeIntoInput(String text) {
        getUIElement(Input.class).sendKeys(DataRandomGenerator.replaceAllGeneratingValues(text));
    }

    @И("ввести в поле ввода дату {date}")
    public void typeDateIntoInput(LocalDate localDate) {
        ((Input) getUIElement(Input.class)).sendKeys(localDate);
    }

    /** Todo: вынести логику неочищаемого Input в отдельный класс и использовать "в {type} {string} ввести {string}" или "в {string} ввести {string}" */
    @Deprecated
    @И("заполнить поле {string} текстом {string}")
    public void textInput(String label, String text) {
        Input inputField = getElementByName(label, Input.class);
        inputField.click();
        inputField.sendKeys(Keys.CONTROL + "a");
        inputField.sendKeys(Keys.CLEAR);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputField.sendKeys(text);
    }

    @И("заполнить поле {string} значением {string}")
    public void setInput(String inputName, String text) {
        UIElement inputElement = getUIElement(Input.class, inputName);
        inputElement.click();
        inputElement.sendKeys(Keys.CONTROL + "a");
        inputElement.sendKeys(Keys.CLEAR);
        inputElement.sendKeys(text);
    }

    @Если("в {type} {string} ввести {string}")
    public void sendKeysToElement(Class<? extends AtlasWebElement> type, String elementName, String args) {
        getElementByName(elementName, type).sendKeys(args);
    }

    @Если("в {string} ввести {string}")
    public void вВвести(String elementName, String value) {
        getElementByName(elementName, AtlasWebElement.class).sendKeys(value);
    }

    @Тогда("проверить, что в поле значение = {string}")
    public void checkInputValueEquals(String expectedValue) {
        String actualValue = getUIElement(Input.class).getText();
        expectedValue = DataRandomGenerator.replaceAllGeneratingValues(expectedValue);

        softAssert().assertEquals(expectedValue, actualValue, "Текст элемента =" + actualValue
                + "'. Не совпадает с ожидаемым значением: '" + expectedValue + '\'');
    }

    @Тогда("в поле {string} значение соответствует {string}")
    public void checkElementTextMatch(String elementName, String expectedValue) {
        String actualText = getElementByName(elementName, UIElement.class).getText();
        softAssert().assertEquals(actualText, expectedValue);
    }

    @Тогда("проверить, что в поле поиска значение = {string}")
    public void checkSearchInputValueEquals(String expectedValue) {
        String actualValue = getUIElement(Input.class).getAttribute("value");
        expectedValue = DataRandomGenerator.replaceAllGeneratingValues(expectedValue);

        softAssert().assertEquals(expectedValue, actualValue, "Текст элемента =" + actualValue
                + "'. Не совпадает с ожидаемым значением: '" + expectedValue + '\'');
    }

    @Тогда("проверить, что в  {element} значение = {string}")
    public void checkInputValueEquals(UIElement element, String expectedValue) {
        String actualValue = element.getText();

        softAssert().assertEquals(expectedValue, actualValue, "Текст элемента  = '" + actualValue
                + "'. Не совпадает с ожидаемым значением: '" + expectedValue + '\'');
    }

    @И("ввести в поле {element} значение {string} и проверить введенное значение.")
    public void typeIntoInputAndCheckValue(UIElement element, String expectedValue) {
        typeIntoInput(element, expectedValue);
        checkInputValueEquals(element, expectedValue);
    }

    @И("очистить поле {element}")
    public void clearInput(UIElement element) {
        element.clear();
    }

    @io.cucumber.java.ru.И("очистить поле с названием {string}")
    public void очиститьПоле(String elementName) {
        getElementByName(elementName, AtlasWebElement.class).clear();
    }

    @И("поле с текстом {string} присутствует")
    public void clearInput(String label) {
        softAssert().assertTrue(getUIElement(Input.class, label).isDisplayed());
    }
    @И("поле с текстом {string} заполнено значением {string}")
    public void clearInput(String label, String value) {
        softAssert().assertTrue(getUIElement(Input.class, label).getAttribute("value").contains(value));
    }
    @И("во всплывающем окне {string} поле с названием {string} присутствует")
    public void fieldIsDisplayed(String popupName, String label) {
        resetCurrentBlock();
        setCurrentBlock(ConfirmModalBlock.class, popupName);
        softAssert().assertTrue(getElementByName(label, Input.class).isDisplayed());
    }

    @И("заполнить поля значениями:")
    public void fillFields(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        for (Map<String, String> l : list) {
            getUIElement(Input.class, l.get("Название поля")).sendKeys(l.get("Значение"));
        }
    }
}
