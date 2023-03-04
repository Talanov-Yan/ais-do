package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import pages.html_elements.Input;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

/** Заготовка для всплывающего окна подтверждения с уникальным локатором (например текст заголовка в две строки) */
public interface ConfirmModalBlock extends ModalBlock, Button.WithButton {
    interface WithConfirmModalBlock extends AbstractBlockElement {
        @FindBy("//*[contains(text(), '{{ text }}')]/../../..")
        ConfirmModalBlock confirmModalBlock(@Param("text") String text);
    }
    @WithName("Причина:")
    @FindBy("//*[@id=\"select2-chosen-50\"]")
    DropDown reason();

    @WithName("Укажите код для получения подарка:")
    @FindBy("//label[contains(text(), 'Укажите код для получения подарка:')]/following::input")
    Input codGift();

}
