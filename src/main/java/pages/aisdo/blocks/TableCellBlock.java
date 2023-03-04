package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.common_blocks.BaseTableCellBlock;
import pages.html_elements.Button;
import pages.html_elements.Link;

import static pages.XPLib.r;

/** Ячейка в строке таблицы по умолчанию для АИС ДО */
public interface TableCellBlock extends BaseTableCellBlock {

    @FindBy(r + "a[contains(@class, '{{ iconClass }}')]")
    Link iconWithClass(@Param("iconClass") String iconClass);

    @FindBy(r + "a[@href]")
    Link btnLink();
}