package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.common_blocks.BaseTableBlock;
import ru.lanit.at.pages.block.AbstractBlockElement;

import static pages.XPLib.$INDEX;
import static pages.XPLib.r;

/** Таблица по умолчанию для АИС ДО */
public interface TableBlock extends BaseTableBlock, TableRowBlock, TableCellBlock {

    @FindBy(r + "tbody//tr" + $INDEX)
    TableRowBlock rowNumber(@Param("index") int index);

    @FindBy(r + "thead/tr")
    TableRowBlock rowHeader();

    @FindBy(r + "tr//td[contains(text(), '{{ text }}')]//..")
    TableRowBlock rowWithText(@Param("text") String text);

    @FindBy(r + "tbody/tr[{{ index }}]")
    TableRowBlock rowOnIndex(@Param("index") int index);

    interface WithTableBlock extends AbstractBlockElement {
        @FindBy("//table")
        TableBlock baseTable();
    }

}