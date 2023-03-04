package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.GeneralInformationBlock;
import pages.aisdo.blocks.ModalBlock;
import pages.html_elements.Button;
import pages.html_elements.Input;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Вожатый")
public interface CounselorPage extends AbstractPage,
        ModalBlock.WithModalBlock,
        GeneralInformationBlock.WithGeneralInformationBlock,
        Button.WithButton {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Counselors/Update");
    }

    @WithName("Имя")
    @FindBy("//input[@id='Data_FirstName']")
    Input inputName();
}
