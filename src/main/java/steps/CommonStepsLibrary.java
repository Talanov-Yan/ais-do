package steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import cucumber.api.java.ru.Тогда;
import io.qameta.atlas.webdriver.AtlasWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.html_elements.Button;
import pages.html_elements.Link;
import pages.html_elements.Text;
import ru.lanit.at.pages.element.UIElement;
import ru.yandex.qatools.matchers.webdriver.EnabledMatcher;

import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public final class CommonStepsLibrary extends BaseSteps {

    /**
     * Check the link address of the element
     *
     * @param expectedLinkAddress expected link address
     */
    @Тогда("проверить что адрес ссылки  = {string}")
    public void checkLinkAddress(String expectedLinkAddress) {
        String actualLinkAddress = ((Link) getUIElement(Link.class)).getLinkAddress();
        softAssert().assertEquals(expectedLinkAddress, actualLinkAddress, "Адрес ссылки '" + actualLinkAddress + "'. Не совпадает с ожидаемым значением: '" + expectedLinkAddress + "'");
    }

    /**
     * Check the text in Page
     *
     * @param text expected text
     */
    @Тогда("отображается элемент с текстом {string}")
    public void assertElementHasText(String text) {
        getUIElement(Text.class, text).should(displayed(), 5);
    }

    // Deprecated: использовать формулировку "элемент с названием {string} отображается"
    @И("элемент {string} присутствует")
    @io.cucumber.java.ru.И("элемент с названием {string} отображается")
    public void elementWithNameShouldBeDisplayed(String nameElement) {
        softAssert().assertTrue(getElementByName(nameElement, UIElement.class).isDisplayed());
    }

    /** Использовать шаг "элемент с названием {string} присутствует" */
    @Deprecated
    @И("поле {string} присутствует")
    public void checkField(String elementName) {
        softAssert().assertTrue(getElementByName(elementName, UIElement.class).isDisplayed());
    }

    @И("на странице присутствует текст {string}")
    public void checkTextOnPage(String text) {
        WebDriver driver = getDriver();
        String[] splitText = text.split(" ");
        String allText = driver.getPageSource();
        for (String text1 : splitText) {
            softAssert().assertTrue(allText.contains(text1));
        }
    }

    @И("{type} {string} присутствует")
    public void checkElementByName(Class<? extends AtlasWebElement> type, String name) {
        softAssert().assertTrue(getElementByName(name, type).isDisplayed());
    }

    @И("кнопка с текстом {string} присутствует")
    public void checkElementByNames(String text) {
        softAssert().assertTrue(getUIElement(Button.class, text).isDisplayed());
    }

    @То("элемент {element} отображается")
    public void checkIsDisplayed(UIElement element) {
        softAssert().assertTrue(element.isDisplayed(), "Элемент '" + element.getClass().getInterfaces()[0] + "' должен отображаться");
    }

    @То("{type} {string} отображается")
    public void checkTypeWithTextIsDisplayed(Class<? extends AtlasWebElement> type, String elementName) {
        softAssert().assertTrue(getElementByName(elementName, type).isDisplayed(), "Элемент должен отображаться");
    }

    @То("элемент {element} не отображается")
    public void checkNotDisplayed(UIElement element) {
        softAssert().assertFalse(element.isDisplayed(), "Элемент '" + element.getClass().getInterfaces()[0] + "'  не должен отображаться");
    }

    @То("элемент {element} доступен")
    public void checkIsEnabled(UIElement element) {
        softAssert().assertTrue(element.isEnabled(), "Элемент '" + element.getClass().getInterfaces()[0] + "' заблокирован на странице");
    }

    @То("элемент {element} заблокирован")
    public void isDisabled(UIElement element) {
        softAssert().assertFalse(element.isEnabled(), "Элемент '" + element.getClass().getInterfaces()[0] + "' не заблокирован на странице");
    }

    @И("подождать, когда элемент {element} станет видимым")
    public void waitUntilVisible(UIElement element) {
        element.should(displayed());
    }

    @И("подождать, когда элемент {element} исчезнет")
    public void waitUntilInVisible(UIElement element) {
        element.should(not(displayed()));
    }

    @И("подождать, когда элемент {element} станет доступен")
    public void waitUntilEnabled(UIElement element) {
        element.should(EnabledMatcher.enabled());
    }

    /**
     * Find element on page by text and execute some action.
     * Available actions : "нажать","проверить на видимость","проверить на отсутствие",
     * "проверить на доступность","проверить на недоступность"
     *
     * @param elementText text the element
     * @param action      action
     */
    @И("^найти (?:элемент) с текстом '(.*)'" +
            " и выполнить действие " +
            "(нажать|проверить на видимость|проверить на отсутствие|проверить на доступность|проверить на недоступность)$")
    public void findAndExecute(String elementText, String action) {
        Text element = getUIElement(Text.class, elementText);
        switch (action) {
            case "нажать": {
                element.click();
                break;
            }
            case "проверить на видимость": {
                element.should(displayed());
                break;
            }
            case "проверить на отсутствие": {
                element.should(not(displayed()));
                break;
            }
            case "проверить на доступность": {
                element.should(EnabledMatcher.enabled());
                break;
            }
            case "проверить на недоступность": {
                element.should(not(EnabledMatcher.enabled()));
                break;
            }
        }
    }
    @И("дождаться появления {type} {string}")
    public void waitLoadPage(Class<? extends UIElement> type, String btnClose) {
        WebDriver driver = getDriver();
        UIElement element = getUIElement(type, btnClose);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 120);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

}