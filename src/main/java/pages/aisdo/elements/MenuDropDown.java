package pages.aisdo.elements;

import pages.html_elements.BaseDropDown;
import pages.html_elements.Link;
import ru.lanit.at.pages.annotations.Title;


/** Выпадающий список пункта меню = DropDown без select = список c ссылками (теги ul-li-a) */
@Title("Пункт меню")
public interface MenuDropDown extends BaseDropDown, Link.WithLink {

    default void selectByValue(String value) {
        this.click();
        link(value).click();
    }
}
