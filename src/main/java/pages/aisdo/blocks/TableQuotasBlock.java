package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Квоты ОИВ")
public interface TableQuotasBlock extends TableBlock {
    interface WithTableQuotasBlock extends AbstractBlockElement {
        @FindBy("//table[2]")
        TableQuotasBlock tableQuotasBlock();
    }
}
