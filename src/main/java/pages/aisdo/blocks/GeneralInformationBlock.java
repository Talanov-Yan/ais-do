package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.CheckBox;
import pages.html_elements.Input;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Общая информация")
public interface GeneralInformationBlock extends AbstractBlockElement, Input.WithInputNewXPath, CheckBox.WithCheckBox {
    interface WithGeneralInformationBlock extends AbstractBlockElement {
        @FindBy("//h3[contains(text(), 'Общая информация')]/..")
        GeneralInformationBlock generalInformationBlock();
    }

}
