package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.*;
import pages.html_elements.Button;
import pages.html_elements.CheckBox;
import pages.html_elements.DropDown;
import pages.html_elements.Text;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.element.UIElement;


@Title(value = "Заявление")
public interface StatementPage extends AbstractPage,
        InformationAboutChildrenBlock.WithInformationAboutChildrenBlock,
        ModalBlock.WithModalBlock,
        Button.WithButton,
        ConfirmModalBlock.WithConfirmModalBlock,
        FieldSetBlock.WithFieldSetBlock,
        DropDown.WithDropDown,
        Text.WithText,
        CheckBox.WithCheckBox {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("FirstRequestCompany/RequestEdit");
    }


}

