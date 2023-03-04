package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.CheckBox;
import pages.html_elements.DropDown;
import pages.html_elements.Input;
import pages.html_elements.RadioButton;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Сведения о детях")
public interface InformationAboutChildrenBlock extends AbstractBlockElement,
        Input.WithInputNewXPath,
        RadioButton.WithRadioButton,
        CheckBox.WithCheckBox,
        DropDown.WithDropDown {
    interface WithInformationAboutChildrenBlock extends AbstractBlockElement {
        @FindBy("//fieldset[@id=\"Childs\"]")
        InformationAboutChildrenBlock informationAboutChildrenBlock();
    }
    @WithName("Номер паспорта в блоке сведения о детях")
    @FindBy("//*[@id=\"Child_0__Data_DocumentNumber\"]")
    Input passportNumberThree();
}
