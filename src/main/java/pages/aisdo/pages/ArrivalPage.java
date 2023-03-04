package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.PersonalModalBlock;
import pages.aisdo.blocks.TableListOfAdministratorsBlock;
import pages.aisdo.blocks.TableListOfPersonalBlock;
import pages.html_elements.Button;
import pages.html_elements.Link;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;


/** Заезд */
@Title(value = "Заезд")
public interface ArrivalPage extends AbstractPage, PersonalModalBlock.WithPersonalModalBlock,
        TableListOfPersonalBlock.WithTableListOfPersonalBlock, TableListOfAdministratorsBlock.WithTableListOfAdministratorsBlock
        , Button.WithButton, Link.WithLink {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Bout/Update/");
    }

    @WithName("Персонал")
    @FindBy("(//a[contains(text(), 'Персонал')])[last()]")
    Link personalLink();

    @WithName("Администраторы смены +")
    @FindBy("//*[@class='btn btn-primary btn-add-administrator-dialog']")
    Button addAdministratorButton();

}
