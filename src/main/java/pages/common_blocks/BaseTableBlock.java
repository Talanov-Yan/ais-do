package pages.common_blocks;

import io.qameta.atlas.webdriver.extension.Param;
import ru.lanit.at.pages.block.AbstractBlockElement;

/** Интерфейс для работы со всеми таблицами */
public interface BaseTableBlock extends AbstractBlockElement, BaseTableRowBlock, BaseTableCellBlock {

    BaseTableRowBlock rowNumber(@Param("index") int index);

    BaseTableRowBlock rowHeader();

    BaseTableRowBlock rowWithText(@Param("text") String text);

    BaseTableRowBlock rowOnIndex(@Param("index") int index);

}