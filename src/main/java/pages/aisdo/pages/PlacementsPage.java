package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import pages.html_elements.Input;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.element.UIElement;

@Title(value = "Размещения")
public interface PlacementsPage extends AbstractPage, Button.WithButton, DropDown.WithDropDown {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Tours/Insert");
    }

    @WithName("Цель обращения")
    @FindBy("//div[@id='s2id_Data_TypeOfRestId']")
    DropDown goalAppeal();

    @WithName("Наименование места отдыха")
    @FindBy("//div[@id='s2id_Data_HotelsId']")
    DropDown namePlaceRest();

    @WithName("Время отдыха")
    @FindBy("//div[@id='s2id_Data_TimeOfRestId']")
    DropDown RestTime();

    @WithName("Год кампании")
    @FindBy("//div[@id='s2id_Data_YearOfRestId']")
    DropDown CampaignYear();

    @WithName("Контракт")
    @FindBy("//div[@id='s2id_Data_ContractId']")
    DropDown contract();

    @WithName("1 (ООО \"Фармапарк\")")
    @FindBy("//*[@id='select2-results-13']/li[2]")
    UIElement farmParck();

    @WithName("Дата начала записи")
    @FindBy("//input[@id='Data_StartBooking']")
    Input StartDateOfRecording();

    @WithName("Дата окончания записи")
    @FindBy("//input[@id='Data_EndBooking']")
    Input EndDateOfRecording();

    @WithName("Номера корпусов")
    @FindBy("//input[@id='Data_CorpusNumber']")
    Input BuildingNumbers();

}
