package steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import pages.html_elements.CheckBox;

public class CheckBoxSteps extends BaseSteps {
    @И("активировать чекбокс")
    public void selectCheckbox() {
        CheckBox checkBox = getUIElement(CheckBox.class);
        checkBox.setChecked(true);
    }

    @И("деактивировать чекбокс")
    public void deselectCheckbox() {
        CheckBox checkBox = getUIElement(CheckBox.class);
        checkBox.setChecked(false);
    }

    @Тогда("проверить, что чекбокс активирован")
    public void checkCheckboxSelected() {
        CheckBox checkBox = getUIElement(CheckBox.class);
        boolean isSelected = checkBox.isSelected();
        softAssert().assertTrue(isSelected, "Ожидалось что чекбокс  активирован.");
    }

    @Тогда("чекбокс не активирован")
    public void checkCheckboxNotSelected() {
        CheckBox checkBox = getUIElement(CheckBox.class);
        boolean isSelected = checkBox.isSelected();
        softAssert().assertFalse(isSelected, "Ожидалось что чекбокс  не активирован.");
    }

    @И("активировать чекбокс {string}")
    public void selectCheckboxByName(String checkBoxName) {
        ((CheckBox) getElementByName(checkBoxName,CheckBox.class)).setChecked(true);
    }

    @Тогда("чекбокс {string} активирован")
    public void checkCheckboxNotSelected(String checkBoxName) {
        softAssert().assertTrue(((CheckBox) getElementByName(checkBoxName, CheckBox.class)).isChecked());
    }

    @И("активировать чекбокс c текстом {string}")
    public void selectCheckboxInPopUpWithText(String text) {
        CheckBox checkBox = getUIElement(CheckBox.class, text);
        checkBox.setChecked(true);
    }

    @И("активировать чекбокс c названием {string}")
    public void selectCheckboxWithName(String checkBoxName) {
        CheckBox checkBox = getElementByName(checkBoxName, CheckBox.class);
        checkBox.setChecked(true);
    }

    @И("чекбокс c текстом {string} активирован")
    public void checkCheckboxOnTrue(String text) {
        CheckBox checkBox = getUIElement(CheckBox.class, text);
        checkBox.isChecked();
    }

    @И("деактивировать чекбокс c текстом {string}")
    public void selectFalseCheckboxWithText(String text) {
        CheckBox checkBox = getUIElement(CheckBox.class, text);
        checkBox.setChecked(false);
    }
}
