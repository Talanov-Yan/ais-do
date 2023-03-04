package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.Input;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Поиск ролей")
public interface SearchRolesBlock extends AbstractBlockElement, Input.WithInputNewXPath, Button.WithButton {
    interface WithSearchRolesBlock extends AbstractBlockElement {
        @FindBy("//*[contains(text(), 'Поиск ролей')]//../../..")
        SearchRolesBlock searchRolesBlock();
    }

    @WithName("Очистить фильтр")
    @FindBy("//*[contains(text(), 'Очистить фильтр')]")
    Button ClearFilter();
}
