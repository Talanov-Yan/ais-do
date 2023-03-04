package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableListOfInstitutionsBlock;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Квоты по учреждениям")
public interface QuotasForInstitutionsPage extends AbstractPage,
        TableListOfInstitutionsBlock.WithTableListOfInstitutionsBlock, Button.WithButton {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("OrganizationList");
    }

    @WithName("Год кампании:")
    @FindBy("//div[@id=\"s2id_Data_YearOfRestId\"]")
    DropDown yearsDropDown();

    @WithName("I смена")
    @FindBy("//div/h4[contains(text(), 'I смена')]")
    Button firstShift();
}
