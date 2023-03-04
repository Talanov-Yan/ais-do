package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Номерной фонд таблица")
public interface TableNumberOfRoomsBlock extends TableBlock {
    interface WithTableNumberOfRoomsBlock extends AbstractBlockElement {
        @FindBy("//table[@id=\"Data_typeOfRoomsTable\"]")
        TableNumberOfRoomsBlock tableNumberOfRoomsBlock();
    }
}
