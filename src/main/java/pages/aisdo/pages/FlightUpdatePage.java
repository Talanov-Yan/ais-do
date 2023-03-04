package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.ModalBlock;
import pages.html_elements.Button;
import pages.html_elements.Input;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.element.UIElement;

@Title(value = "Рейс")
public interface FlightUpdatePage extends AbstractPage,
        ModalBlock.WithModalBlock,
        Button.WithButton,
        Input.WithInputNewXPath {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("DirectoryFlights/Update");
    }

}
