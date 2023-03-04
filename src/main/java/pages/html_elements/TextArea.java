package pages.html_elements;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.element.UIElement;

@Title("Текстовое поле")
public interface TextArea extends UIElement {


    interface WithTextArea extends UIElement {
        @FindBy(".//textarea")
        TextArea text();

        @FindBy("//label[contains(text(), '{{ label }}')]//following-sibling::div/textarea")
        TextArea textArea(@Param("label") String labelText);
    }
}
