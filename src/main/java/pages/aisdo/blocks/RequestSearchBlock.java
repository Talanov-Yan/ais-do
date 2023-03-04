package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.CheckBox;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Поиск заявлений")
public interface RequestSearchBlock extends AbstractBlockElement, Button.WithButton, DropDown.WithDropDown {
    interface WithRequestSearchBlock extends AbstractBlockElement {
        @FindBy("(//form[@action='/FirstRequestCompany/RequestList'])[1]")
        RequestSearchBlock requestSearchBlock();
    }

    @WithName("Сертификат погашен")
    @FindBy("(.//input[@id='CertificateRepaid'])[1]")
    CheckBox certificateRepaid();
}