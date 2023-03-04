package pages.aisdo.pages;


import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;


/** Списки профсоюзов */
@Title(value = "Списки профсоюзов")
public interface TradeUnionPage extends AbstractPage, TableBlock.WithTableBlock, Button.WithButton { // Ян Таланов изменил
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("/TradeUnion/List");
    }

    @WithName("Год кампании")
    @FindBy("//*[@id='s2id_YearOfRestId']")
    DropDown yearCompanyDropDown();

    @WithName("Статус")
    @FindBy("//*[@id='s2id_StateId']")
    DropDown statusDropDown();

}
