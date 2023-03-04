package pages.html_elements;

import ru.lanit.at.pages.element.UIElement;

public interface BaseDropDown extends UIElement {

    void selectByValue(String value);

    void selectByIndex(int index);

    void selectMultipleItemsInDropdown(String... selectedLabels);

    String getSelectedInDropdownValue();
}
