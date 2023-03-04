package pages.aisdo;

import pages.aisdo.blocks.ConfirmModalBlock;
import pages.aisdo.blocks.ModalBlock;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.Button;
import pages.html_elements.DropDown;
import pages.html_elements.Input;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title(value = "Реестр выдачи подарков")
public interface RegisterGiftIssuancePage extends AbstractPage,
        Input.WithInputNewXPath,
        DropDown.WithDropDown,
        Button.WithButton,
        TableBlock.WithTableBlock,
        ModalBlock.WithModalBlock,
        ConfirmModalBlock.WithConfirmModalBlock {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("GiftReserved/List");
    }
}
