package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Подарки")
public interface GiftsTableBlock extends TableBlock {
    interface WithGiftsTable extends AbstractBlockElement {
        @FindBy("//*[contains(text(),'Подарки')]/following::table")
        GiftsTableBlock tableGiftsBlock();
    }
}
