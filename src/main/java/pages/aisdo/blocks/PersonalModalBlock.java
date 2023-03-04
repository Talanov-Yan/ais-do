package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.common_blocks.BaseModalBlock;
import pages.html_elements.Button;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

/** Блок персонала для работы с окнами добавления Администратора смены, старшего вожатого, подменного вожатого в заезд */
@Title(value = "Администраторы")
public interface PersonalModalBlock extends BaseModalBlock, Button.WithButton {

    interface WithPersonalModalBlock extends AbstractBlockElement {
        @FindBy("//*[@class='modal-title counselors-modal-title']/../..")
        PersonalModalBlock personalModalBlock();

        @FindBy("//*[@class='modal-title counselors-modal-title']/../..")
        PersonalModalBlock personalModalBlockParam(@Param("title") String title);
    }
}