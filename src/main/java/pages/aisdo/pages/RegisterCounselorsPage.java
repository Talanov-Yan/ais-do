package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Реестр вожатых")
public interface RegisterCounselorsPage extends AbstractPage,
        TableBlock.WithTableBlock, Button.WithButton {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Counselors/Search");
    }

    @WithName("Статус")
    @FindBy("//*[@id=\"select2-chosen-2\"]")
    DropDown status();
}