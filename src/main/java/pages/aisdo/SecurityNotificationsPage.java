package pages.aisdo;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableBlock;
import pages.aisdo.elements.MenuDropDown;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Уведомления безопасности")
public interface SecurityNotificationsPage extends AbstractPage,
        TableBlock.WithTableBlock {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("SecurityJournal/JournalSecurityEvents");
    }

    @WithName("Журнал безопасности")
    @FindBy("descendant::a[contains(text(), 'Журнал безопасности')]")
    MenuDropDown securityLog();
}
