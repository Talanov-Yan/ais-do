package pages.aisdo.pages;

import pages.aisdo.blocks.CommonInfoWorkDayBlock;
import pages.html_elements.Button;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title(value = "Изменение рабочих дней Отдел приема документов")
public interface WorkingDayManageDepOfDocs extends AbstractPage, CommonInfoWorkDayBlock.WithCommonInfoWorkDay, Button.WithButton {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("BookingMosgorturReestr/DayManage/");
    }
}

