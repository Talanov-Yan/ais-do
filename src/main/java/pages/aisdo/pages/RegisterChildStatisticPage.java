package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.*;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;


@Title(value = "Реестр статистики по детям")
public interface RegisterChildStatisticPage extends AbstractPage,
        TableBlock.WithTableBlock, DropDown.WithDropDown, Input.WithInput, Text.WithText, Button.WithButton {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("/NewBout/ChildList");
    }

    @WithName("Смена")
    @FindBy("descendant::label[contains(normalize-space(.), 'Смена')]/..//*[contains(@class,'select2-container')]")
    DropDownWithoutInput requestPurpose();

    @WithName("Город")
    @FindBy("(.//*/text()[contains(normalize-space(translate(string(.), '	   ', '    ')), 'Город')]/parent::* )[2]")
    Input cityInp();

    @WithName("ФИО")
    @FindBy("(.//*/text()[contains(normalize-space(translate(string(.), '\t   ', '    ')), 'ФИО')]/parent::* )[1]")
    Input fioInp();

}