package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Button;
import pages.html_elements.Link;
import pages.html_elements.Text;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Реестр размещений")
public interface RegisterOfPlacementsPage extends AbstractPage, Button.WithButton, Link.WithLink, Text.WithText {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Tours/Search");
    }
}

