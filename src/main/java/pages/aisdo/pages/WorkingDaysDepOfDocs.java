package pages.aisdo.pages;

import pages.aisdo.blocks.TableBlock;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title(value = "Рабочие дни Отдел приема документов")
public interface WorkingDaysDepOfDocs extends AbstractPage,
        TableBlock.WithTableBlock {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("BookingMosgorturReestr/WorkingDays");
    }
}
