package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Номерной фонд")
public interface NumberOfRoomsBlock extends AbstractBlockElement, Button.WithButton {
    interface WithNumberOfRoomsBlock extends AbstractBlockElement {
        @FindBy("//span[contains(text(), 'Номерной фонд')]/../..")
        NumberOfRoomsBlock numberOfRoomsBlock();
    }
}
