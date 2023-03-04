package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

/** Таблица не отличается от TableBlock */
@Deprecated
@Title(value = "Дети")
public interface TableChildrenBlock extends TableBlock {
    interface WithTableChildrenBlock extends AbstractBlockElement {
        @FindBy("//table")
        TableChildrenBlock tableChildrenBlock();
    }
}