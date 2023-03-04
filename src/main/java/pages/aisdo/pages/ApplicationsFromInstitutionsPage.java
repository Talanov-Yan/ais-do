package pages.aisdo.pages;

import pages.aisdo.blocks.ModalBlock;
import pages.html_elements.Button;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

@Title(value = "Заявки от учреждений (списки детей)")
public interface ApplicationsFromInstitutionsPage extends AbstractPage,
        ModalBlock.WithModalBlock,
        Button.WithButton {
    @Override
    default boolean isOpen() {
        return getWrappedDriver().getCurrentUrl().contains("Limits/ListOfChildsList");
    }

}
