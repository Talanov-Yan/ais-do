package pages.html_elements;

import io.qameta.atlas.core.api.Retry;
import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.element.UIElement;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static pages.XPLib.r;

/** Выпадающий список с полем для ввода */
@Title("ДропДаун")
public interface DropDown extends BaseDropDown {

    default void selectByValue(String value) {
        this.click();
        setInputText().clear();
        setInputText().sendKeys(value);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (selectElement(value).isDisplayed()) {
            selectElement(value).click();
        } else {
            setInputText().sendKeys(Keys.ENTER);
        }
    }

    default void selectByIndex(int index) {
        this.sendKeys();
    }

    default void selectMultipleItemsInDropdown(String... selectedLabels) {
        sendKeys(selectedLabels);
    }

    default String getSelectedInDropdownValue() {
        return getText();
    }

    default boolean checkAttributeClassOnDisable() {
        return getAttribute("class").contains("disabled");
    }

    @FindBy("//div[@id=\"select2-drop-mask\"]//following-sibling::div/div/input")
    Input setInputText();

    interface WithDropDown extends UIElement {
        @FindBy(".//select")
        ElementsCollection<DropDown> dropDowns();

        @Retry(timeout = 21000, ignoring = NoSuchElementException.class)
        @FindBy(r + "label[contains(normalize-space(.), '{{ labelText }}')]/..//*[contains(@class,'select2-container')]")
        DropDown dropDown(@Param(value = "labelText") String labelText);

        @FindBy("(//label[contains(normalize-space(.), '{{ labelText }}')]/..//*[contains(@class,'select2-container')])[{{ index }}]")
        DropDown dropDownWithIndex(@Param(value = "labelText") String labelText, @Param(value = "index") String index);

        default DropDown dropDown() {
            DropDown i = dropDowns().filter(AtlasWebElement::isDisplayed).waitUntil(hasSize(greaterThan(0))).get(0);
            return i;
        }
    }

    @FindBy("//div[@id=\"select2-drop-mask\"]//following-sibling::div//*[contains(text(), '{{ text }}')]")
    UIElement selectElement(@Param("text") String text);
}