package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.ModalBlock;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.Button;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.element.UIElement;


/** Транспорт */
@Title(value = "Транспорт")
public interface TransportPage extends AbstractPage, TableBlock.WithTableBlock, ModalBlock.WithModalBlock, Button.WithButton {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("TransportInfo/Update/");
    }

    @WithName("Подтвердить действие")
    @FindBy("//div[contains(text(), 'Подтвердить действие')]/../../..")
    UIElement confirmWindowPopup();

}
