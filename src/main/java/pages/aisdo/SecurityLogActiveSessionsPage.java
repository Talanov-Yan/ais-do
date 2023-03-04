package pages.aisdo;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.aisdo.blocks.TableBlock;
import pages.aisdo.elements.MenuDropDown;
import pages.html_elements.Button;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Журнал безопасности. Активные сессии.")
public interface SecurityLogActiveSessionsPage extends AbstractPage,
        TableBlock.WithTableBlock {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("SecurityJournal/JournalActiveSessions");
    }

    @WithName("Остановить сессию")
    @FindBy("//button[@title = 'Остановить сессию']")
    Button StopSession();

    @WithName("Журнал безопасности")
    @FindBy("descendant::a[contains(text(), 'Журнал безопасности')]")
    MenuDropDown securityLog();
}
