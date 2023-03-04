package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.ModalBlock;
import pages.aisdo.blocks.NumberOfRoomsBlock;
import pages.aisdo.blocks.PlacementOptionsBlock;
import pages.aisdo.blocks.TableNumberOfRoomsBlock;
import pages.html_elements.Button;
import pages.html_elements.Input;
import pages.html_elements.Link;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.element.UIElement;

@Title(value = "Оздоровительная организация")
public interface WellnessOrganizationPage extends AbstractPage,
        TableNumberOfRoomsBlock.WithTableNumberOfRoomsBlock,
        PlacementOptionsBlock.WithPlacementOptionsBlock,
        NumberOfRoomsBlock.WithNumberOfRoomsBlock,
        ModalBlock.WithModalBlock,
        Button.WithButton,
        Input.WithInputNewXPath,
        Link.WithLink {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Hotels/Update");
    }

    @WithName("Номерной фонд")
    @FindBy("//a[contains(text(), 'Номерной фонд')]")
    UIElement numberRooms();
}
