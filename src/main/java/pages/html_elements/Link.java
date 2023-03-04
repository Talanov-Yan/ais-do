package pages.html_elements;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.element.UIElement;

@Title("Ссылка")
public interface Link extends UIElement {


    default String getLinkAddress() {
        return getAttribute("href");
    }


    interface WithLink extends UIElement {
        @FindBy(".//a")
        Link link();

        @FindBy("//a[contains(text(), '{{ name }}')]")
        Link link(@Param("name") String name);
    }
}
