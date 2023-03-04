package pages.common_blocks;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.Param;
import pages.html_elements.Button;
import pages.html_elements.Link;
import ru.lanit.at.pages.block.AbstractBlockElement;

/** Строка в таблице */
public interface BaseTableRowBlock extends AbstractBlockElement, BaseTableCellBlock {

    ElementsCollection<? extends BaseTableCellBlock> allCells();

    BaseTableCellBlock columnIndex(@Param("index") int index);

    Button iconWithTitle(@Param("iconTitle") String iconTitle);

    Link iconWithClass(@Param("iconClass") String iconClass);

    Button buttonWithText(@Param("buttonText") String buttonText);

}
