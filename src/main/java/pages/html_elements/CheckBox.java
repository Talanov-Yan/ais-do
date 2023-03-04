package pages.html_elements;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.element.UIElement;

import static pages.XPLib.r;

@Title("Чекбокс")
public interface CheckBox extends UIElement {


    default boolean isChecked() {
        return this.isSelected();
    }

    default void setChecked(boolean checked) {
        if (checked) {
            if (!isChecked()) {
                this.click();
            }
        } else {
            if (isChecked()) {
                this.click();
            }
        }
    }

    interface WithCheckBox extends UIElement {
        @FindBy(".//input[@type='checkbox']")
        CheckBox checkBox();

        @FindBy(r + "label[contains(normalize-space(.), '{{ text }}')]//input[@type='checkbox']")
        CheckBox checkBox(@Param(value = "text") String text);
    }
}
