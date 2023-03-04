package pages.aisdo;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.elements.MenuDropDown;
import pages.html_elements.Button;
import pages.html_elements.CheckBox;
import pages.html_elements.Input;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Роль")
public interface RolePage extends AbstractPage,
        Button.WithButton,
        Input.WithInputNewXPath,
        CheckBox.WithCheckBox {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Role/Insert");
    }

    @WithName("Настройки безопасности")
    @FindBy("descendant::a[contains(text(), 'Настройки безопасности')]")
    MenuDropDown securitySettings();
}
