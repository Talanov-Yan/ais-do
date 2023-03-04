package pages.aisdo.pages;

import pages.html_elements.Button;
import pages.html_elements.Link;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title(value = "Рабочие дни Все отделы")
public interface WorkingDaysAllDeps extends AbstractPage, Button.WithButton, Link.WithLink {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("BookingMosgorturReestr/WorkingDays");
    }
}
