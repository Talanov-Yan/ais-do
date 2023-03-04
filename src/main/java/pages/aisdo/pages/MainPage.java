package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.elements.MenuDropDown;
import pages.html_elements.Link;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

/** Главная страница */
@Title(value = "Главная страница")
public interface MainPage extends AbstractPage, DropDown.WithDropDown, Link.WithLink {

    @WithName("Заезды")
    @FindBy("descendant::a[contains(text(), 'Заезды')]")
    MenuDropDown arrivals();

    @WithName("Льготники/Профильники")
    @FindBy("//li/a[contains(text(), 'Льготники/Профильники')]/..")
    MenuDropDown lgot_prof();

    @WithName("Профсоюзные списки")
    @FindBy("//*[@href='/TradeUnion/List']")
    MenuDropDown tradeUnionList();

    @WithName("Справочники")
    @FindBy("descendant::a[contains(text(), 'Справочники')]")
    MenuDropDown references();

    @WithName("Настройки безопасности")
    @FindBy("descendant::a[contains(text(), 'Настройки безопасности')]")
    MenuDropDown securitySettings();

}
