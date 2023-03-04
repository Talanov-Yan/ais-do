package pages.aisdo;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.ModalBlock;
import pages.aisdo.blocks.SearchRolesBlock;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.Button;
import pages.html_elements.Input;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.element.UIElement;

@Title(value = "Роли пользователей")
public interface UserRolesPage extends AbstractPage,
        TableBlock.WithTableBlock,
        SearchRolesBlock.WithSearchRolesBlock,
        Input.WithInputNewXPath,
        Button.WithButton {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Role/Search");
    }

    @WithName("Добавить роль")
    @FindBy("/html/body/div[3]/div[2]/div/a")
    Button addRole();

    @WithName("иконка Карандаша")
    @FindBy("//a[@class= ' glyphicon glyphicon-pencil']")
    Button glyphiconPencil();

    @WithName("иконка Корзины")
    @FindBy("//a[@class= ' glyphicon glyphicon-trash text-danger']")
    Button glyphiconTrash();
}
