package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Реестр рейсов")
public interface FlightRegistryPage extends AbstractPage,
        TableBlock.WithTableBlock,
        Button.WithButton {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("DirectoryFlights/Search");
    }

    @WithName("Год кампании")
    @FindBy("//div[@id='s2id_YearOfRestId']/..")
    DropDown yearsDropDown();

}
