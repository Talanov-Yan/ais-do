package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Список учреждений")
public interface TableListOfInstitutionsBlock extends TableBlock {
    interface WithTableListOfInstitutionsBlock extends AbstractBlockElement {
        @FindBy("//table[@id=\"result\"]")
        TableListOfInstitutionsBlock tableListOfInstitutionsBlock();
    }
}
