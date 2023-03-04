package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.ConfirmModalBlock;
import pages.aisdo.blocks.ModalBlock;
import pages.aisdo.blocks.TableQuotasBlock;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Квоты ОИВ")
public interface QuotasOIVPage extends AbstractPage,
        TableQuotasBlock.WithTableQuotasBlock,
        ModalBlock.WithModalBlock,
        ConfirmModalBlock.WithConfirmModalBlock, Button.WithButton {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("VedomstvoList");
    }

    @WithName("Год кампании")
    @FindBy("//div[@id='s2id_Data_Id']")
    DropDown yearsCompany();

    /* По ТК поиск элемента таблицы происходит в контексте страницы, что не совсем правильно, так как элемент может быть не на той строчке */
    @WithName("иконка Карандаша")
    @FindBy("//td//a[@class = 'operation btn glyphicon glyphicon-pencil']")
    Button iconPencil();

    /* По ТК поиск элемента таблицы происходит в контексте страницы, что не совсем правильно, так как элемент может быть не на той строчке */
    @WithName("Редактировать иконка")
    @FindBy("//a[@class = 'btn glyphicon glyphicon-edit edit ']")
    Button iconEditBtn();

    @WithName("Подтвердить иконка")
    @FindBy("//a[@title = 'Подтвердить']")
    Button btnConfirm();

}
