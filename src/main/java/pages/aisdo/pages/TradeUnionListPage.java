package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.ModalBlock;
import pages.aisdo.blocks.TableChildrenBlock;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.element.UIElement;

@Title(value = "Профсоюзный список")
public interface TradeUnionListPage extends AbstractPage,
        TableChildrenBlock.WithTableChildrenBlock,
        ModalBlock.WithModalBlock,
        Button.WithButton {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("TradeUnion/Edit");
    }

    @WithName("Год кампании")
    @FindBy("//*[@id=\"requestForm\"]/fieldset/div[1]/div[2]")
    DropDown yearsDropDown();

    @WithName("Лагерь")
    @FindBy("//div[@id='s2id_Data_CampId']")
    DropDown dropDownCamp();

}
