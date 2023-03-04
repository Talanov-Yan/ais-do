package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

/** Таблица не отличается от TableBlock */
@Deprecated
@Title(value = "Реестр транспорта")
public interface TableTransportRegistryBlock extends TableBlock {
    interface WithTransportRegistryBlock extends AbstractBlockElement {
        @FindBy("//table")
        TableTransportRegistryBlock tableChildrenBlock();
    }
}