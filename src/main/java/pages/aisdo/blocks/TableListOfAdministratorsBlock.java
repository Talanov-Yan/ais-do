package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Администраторы смены")
public interface TableListOfAdministratorsBlock extends TableBlock {

    interface WithTableListOfAdministratorsBlock extends AbstractBlockElement {
        @FindBy("//*[@id=\"AdministratorsTourTable\"]")
        TableListOfAdministratorsBlock tableListOfAdministratorsBlock();
    }
}