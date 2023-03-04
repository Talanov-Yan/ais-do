package pages.common_blocks;

import io.qameta.atlas.webdriver.extension.Param;
import pages.html_elements.Button;
import pages.html_elements.Link;
import ru.lanit.at.pages.block.AbstractBlockElement;
import ru.lanit.at.pages.element.UIElement;


/** Ячейка в таблице */
public interface BaseTableCellBlock extends AbstractBlockElement, UIElement {

    Link iconWithClass(@Param("iconClass") String iconClass);

    Link btnLink();

}