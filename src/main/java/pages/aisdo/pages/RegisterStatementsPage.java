package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import pages.aisdo.blocks.RequestSearchBlock;
import pages.aisdo.blocks.TableBlock;
import pages.html_elements.Button;
import pages.html_elements.Link;
import pages.html_elements.Text;
import pages.html_elements.TextArea;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;

@Title(value = "Реестр заявлений")
public interface RegisterStatementsPage extends AbstractPage,
        TableBlock.WithTableBlock, RequestSearchBlock.WithRequestSearchBlock, Button.WithButton, Link.WithLink {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("FirstRequestCompany/RequestList");
    }

    @FindBy("//div[contains(text(), '{{ text }}')]")
    Text text(@Param("text") String text);

    @WithName("Номер заявления")
    @FindBy("//input[@name='RequestNumber']")
    TextArea requestNumber();

    @WithName("Добавить заявление")
    @FindBy("(//a/i/..)[1]")
    Button addApplication();
}