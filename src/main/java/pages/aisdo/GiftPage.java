package pages.aisdo;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.ModalBlock;
import pages.html_elements.Button;
import pages.html_elements.Input;
import pages.html_elements.TextArea;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Подарок")
public interface GiftPage extends AbstractPage,
        Input.WithInputNewXPath,
        Button.WithButton,
        ModalBlock.WithModalBlock {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Gift/Manage");
    }

    @WithName("Описание подарка")
    @FindBy("//label[contains(text(), 'Описание подарка')]//following-sibling::div/textarea")
    TextArea DescriptionGift();

    @WithName("Добавить параметр")
    @FindBy("//*[@id=\"btnParameter\"]")
    Button addParam();
}
