package pages.common_blocks;

import pages.html_elements.Button;
import pages.html_elements.Input;
import ru.lanit.at.pages.block.AbstractBlockElement;

/** Общий интерфейс для всплывающих модальных окон (блокирует интерфейс, ожидает действия пользователя) */
public interface BaseModalBlock extends AbstractBlockElement, Button.WithButton, Input.WithInputNewXPath {

}
