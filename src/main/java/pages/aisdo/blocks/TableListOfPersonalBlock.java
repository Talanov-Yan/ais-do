package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Список персонала")
public interface TableListOfPersonalBlock extends TableBlock, Button.WithButton {

    interface WithTableListOfPersonalBlock extends AbstractBlockElement {
        @FindBy("//*[@id=\"CounselorsDialogBody\"]/table")
        TableListOfPersonalBlock tableListOfPersonalBlock();
    }
}