package steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import pages.aisdo.blocks.ConfirmModalBlock;
import pages.html_elements.BaseDropDown;
import pages.html_elements.DropDown;

import java.util.List;
import java.util.Map;

public class DropDownSteps extends BaseSteps {

    @И("в выпадающем списке {string} выбрать {string}")
    public void selectInDropdownByName(String dropdownName, String valueName) {
        ((BaseDropDown) getElementByName(dropdownName, BaseDropDown.class)).selectByValue(valueName);
    }

    @И("в выпадающих списках выбрать значения")
    public void selectInDropDown(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        for (Map<String, String> l : list) {
            String[] fieldName = {l.get("Название списка"), l.get("Индекс")};
            ((BaseDropDown) getUIElement(DropDown.class, fieldName)).selectByValue(l.get("Значение"));
        }
    }

    @И("в выпадающем списке с заголовком {string} выбрать {string}")
    public void selectInDropdownByLabel(String labelName, String valueName) {
        ((BaseDropDown) getUIElement(BaseDropDown.class, labelName)).selectByValue(valueName);
    }

    /**
     * Select options in dropdown
     *
     * @param values options
     */
    @И("в выпадающем списке выбрать:")
    public void selectMultipleValuesInDropdown(List<String> values) {
        ((DropDown) getUIElement(DropDown.class)).selectMultipleItemsInDropdown(values.toArray(new String[0]));
    }

    /**
     * Check selected option in dropdown
     *
     * @param expectedValue expected option
     */
    @Тогда("в выпадающем списке  выбрано {string}")
    public void checkThatValueInDropdownChosen(String expectedValue) {
        String actualValue = ((DropDown) getUIElement(DropDown.class)).getSelectedInDropdownValue();
        softAssert().assertEquals(expectedValue, actualValue, "Выбранное в элементе  значение '" + actualValue + "'  не соответствует ожидаемому значению '" + expectedValue + "'");
    }

    @И("в выпадающих списках выбраны значения")
    public void checkValuesInDropDowns(DataTable table) {
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        for (Map<String, String> l : list) {
            String[] fieldName = {l.get("Название списка"), l.get("Индекс")};
            String expectedValue = l.get("Ожидаемое значение");
            String actualValue = ((BaseDropDown) getUIElement(DropDown.class, fieldName)).getSelectedInDropdownValue();
            softAssert().assertEquals(expectedValue, actualValue, "Выбранное в элементе  значение '" + actualValue + "'  не соответствует ожидаемому значению '" + expectedValue + "'");
        }
    }

    @И("на странице недоступны выпадающие списки:")
    public void checkFields(List<String> fields) {
        for (String field : fields) {
            softAssert().assertTrue(((DropDown) getElementByName(field, DropDown.class)).checkAttributeClassOnDisable(),
                    "Поле " + field + " доступно");
        }
    }

    @И("во всплывающем окне {string} в выпадающем списке {string} выбрать {string}")
    public void dropdownInPopup(String popupName, String dropdownName, String valueName) {
        resetCurrentBlock();
        setCurrentBlock(ConfirmModalBlock.class, popupName);
        ((BaseDropDown) getElementByName(dropdownName, BaseDropDown.class)).selectByValue(valueName);
    }
}
