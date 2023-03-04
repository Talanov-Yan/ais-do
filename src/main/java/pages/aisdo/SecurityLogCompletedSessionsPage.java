package pages.aisdo;

import pages.aisdo.blocks.TableBlock;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title(value = "Журнал безопасности. Завершенные сессии.")
public interface SecurityLogCompletedSessionsPage extends AbstractPage,
        TableBlock.WithTableBlock {

    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("SecurityJournal/JournalStopedSessions");
    }
}
