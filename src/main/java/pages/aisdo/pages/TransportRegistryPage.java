package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableTransportRegistryBlock;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import pages.html_elements.Input;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;


/** Реестр транспорта */
@Title(value = "Реестр транспорта")
public interface TransportRegistryPage extends AbstractPage, TableTransportRegistryBlock.WithTransportRegistryBlock, Button.WithButton {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("/TransportInfo/Search");
    }

    @WithName("Год кампании")
    @FindBy("//*[@id='s2id_YearOfRestId']")
    DropDown yearCompanyDropDown();

    @WithName("Статус")
    @FindBy("//*[@id='s2id_StateId']")
    DropDown statusDropDown();

    @WithName("Дата отправления С")
    @FindBy("//*[@id='DateOfDepartureBegin']")
    Input dataStart();

}
