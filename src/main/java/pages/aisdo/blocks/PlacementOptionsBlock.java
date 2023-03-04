package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.html_elements.Input;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.annotations.WithName;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Варианты размещений")
public interface PlacementOptionsBlock extends AbstractBlockElement {
    interface WithPlacementOptionsBlock extends AbstractBlockElement {
        @FindBy("//span[contains(text(), 'Варианты размещений')]/../..")
        PlacementOptionsBlock placementOptionsBlock();
    }
    @WithName("Название")
    @FindBy("//label[contains(text(), 'Название')]/../..//input")
    Input title();

    @WithName("Количество взрослых")
    @FindBy("//label[contains(text(), 'Количество взрослых')]/../..//input")
    Input NumberAdults();

    @WithName("Минимальный возраст")
    @FindBy("//th[1]/../../../tbody//td[1]/input")
    Input minimumAge();

    @WithName("Максимальный возраст")
    @FindBy("//th[2]/../../../tbody//td[2]/input")
    Input maximumAge();

    @WithName("Количество детей")
    @FindBy("//th[3]/../../../tbody//td[3]/input")
    Input NumberChildren();


}
