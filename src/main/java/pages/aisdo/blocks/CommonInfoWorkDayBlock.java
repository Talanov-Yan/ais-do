package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.*;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Общие сведения о рабочем дне")
public interface CommonInfoWorkDayBlock extends AbstractBlockElement, DropDown.WithDropDown, Button.WithButton, Link.WithLink {
    interface WithCommonInfoWorkDay extends AbstractBlockElement {
        @FindBy("//form[@action='/BookingMosgorturReestr/SaveDay']")
        CommonInfoWorkDayBlock commonInfoWorkDay();
    }

    @WithName("Добавить интервал")
    @FindBy("(//button[@class='btn btn-primary btn-warning add-interval'])[2]")
    Button addIntervalBtn();

    @WithName("№ Окна")
    @FindBy("//input[@name='Windows[1].WindowNumber']")
    Input numberWindow();

    @WithName("Цели обращения")
    @FindBy("//div[@id='s2id_Windows_1__SelectedTargets']")
    DropDownWithoutInput requestPurpose();

}
