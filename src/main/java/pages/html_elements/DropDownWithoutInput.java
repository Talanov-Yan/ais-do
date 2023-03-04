package pages.html_elements;

import org.openqa.selenium.Keys;

public interface DropDownWithoutInput extends DropDown {

    default void selectByValue(String value) {
        this.click();
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
}
