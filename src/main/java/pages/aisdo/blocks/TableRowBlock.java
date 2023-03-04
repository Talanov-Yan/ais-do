package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.ElementsCollection;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.common_blocks.BaseTableRowBlock;
import pages.html_elements.Button;
import pages.html_elements.Link;

import static pages.XPLib.r;

/** Строка в таблице по умолчанию для АИС ДО */
public interface TableRowBlock extends BaseTableRowBlock, TableCellBlock {

    @FindBy(r + "th")
    ElementsCollection<TableCellBlock> allCells();

    @FindBy(r + "td[{{ index }}]")
    TableCellBlock columnIndex(@Param("index") int index);

    @FindBy("//a[@title = '{{ iconTitle }}']")
    Button iconWithTitle(@Param("iconTitle") String iconTitle);

    @FindBy(r + "a[contains(@class, '{{ iconClass }}')]")
    Link iconWithClass(@Param("iconClass") String iconClass);

    @FindBy(r + "button[contains(text(), '{{ buttonText }}')]")
    Button buttonWithText(@Param("buttonText") String buttonText);

}
