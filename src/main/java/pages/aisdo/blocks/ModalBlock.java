package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.common_blocks.BaseModalBlock;
import pages.html_elements.Button;
import pages.html_elements.CheckBox;
import pages.html_elements.Input;
import ru.lanit.at.pages.block.AbstractBlockElement;

import static pages.XPLib.a;

/** Стандартное модальное окно системы Детский отдых */
public interface ModalBlock extends BaseModalBlock,
        CheckBox.WithCheckBox, Button.WithButton, Input.WithInputNewXPath {

    interface WithModalBlock extends AbstractBlockElement {
        @FindBy("//div[@class='modal-dialog']")
        ModalBlock withBaseModalBlock();

        @FindBy("//div[@class='modal-dialog']//*[contains(text(), '{{ title }}')]" + a + "div[@class='modal-dialog']")
        ModalBlock withBaseModalBlockParam(@Param("title") String title);

        @FindBy("//div[@class='modal-content']//*[contains(text(), '{{ title }}')]" + a + "div[@class='modal-content']")
        ModalBlock withBaseModalBlockWithParam(@Param("title") String title);
    }
}
