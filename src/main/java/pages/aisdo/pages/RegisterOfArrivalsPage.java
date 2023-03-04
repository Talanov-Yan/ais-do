package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;


/** Реестр заездов */
@Title(value = "Реестр заездов")
public interface RegisterOfArrivalsPage extends AbstractPage, TableBlock.WithTableBlock, Button.WithButton {
    @Override
    default boolean isOpen() {
        // todo: метод не должен зависеть от стенда
        return getWrappedDriver().getCurrentUrl().contains("/Bout/Search");
    }

    @WithName("Год кампании")
    @FindBy("//*[@id='s2id_YearOfRestId']/a")
    DropDown yearCompanyDropDown();

    @WithName("Статус")
    @FindBy("//*[@id='s2id_StateId']/a")
    DropDown statusDropDown();

}
