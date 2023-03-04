package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.html_elements.CheckBox;
import pages.html_elements.DropDown;
import pages.html_elements.Input;
import pages.html_elements.RadioButton;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

import static pages.XPLib.a;

@Title("Блок с полями")
public interface FieldSetBlock extends AbstractBlockElement, DropDown.WithDropDown, Input.WithInputNewXPath, CheckBox.WithCheckBox, RadioButton.WithRadioButton {
    interface WithFieldSetBlock {
        @FindBy("//fieldset/*[contains(text(), '{{ title }}')]" + a + "fieldset")
        FieldSetBlock fieldSet(@Param(value = "title") String title);
    }

    @WithName("Дополнительное в блоке Цель обращения")
    @FindBy("//*[@id=\"select2-chosen-37\"]")
    DropDown additionalField2One();

    @WithName("Дополнительное в блоке Место отдыха")
    @FindBy("//*[@id=\"select2-chosen-40\"]")
    DropDown additionalField2Two();

    @WithName("Номер паспорта в блоке сведения о заявителе")
    @FindBy("//*[@id=\"Applicant_Data_DocumentNumber\"]")
    Input passportNumberOne();

    @WithName("Номер паспорта в блоке сведения о представителе заявителя")
    @FindBy("//*[@id=\"Agent_Data_DocumentNumber\"]")
    Input passportNumberTwo();

}
