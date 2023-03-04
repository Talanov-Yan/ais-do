package pages.aisdo;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableBlock;
import pages.aisdo.elements.MenuDropDown;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import pages.html_elements.Input;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Реестр подарков")
public interface GiftRegistryPage extends AbstractPage,
        TableBlock.WithTableBlock,
        Input.WithInputNewXPath,
        Button.WithButton,
        DropDown.WithDropDown {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Gift/List");
    }

    @WithName("Добавить")
    @FindBy("//text()[normalize-space(.) ='Добавить']//..")
    Button add();

    @WithName("Заезды")
    @FindBy("descendant::a[contains(text(), 'Заезды')]")
    MenuDropDown arrivals();
}
