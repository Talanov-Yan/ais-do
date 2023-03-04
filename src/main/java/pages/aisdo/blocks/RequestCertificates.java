package pages.aisdo.blocks;

import io.qameta.atlas.webdriver.extension.FindBy;
import pages.common_blocks.BaseTableBlock;
import ru.lanit.at.pages.annotations.Title;
import ru.lanit.at.pages.block.AbstractBlockElement;

@Title(value = "Сведения о погашенном сертификате")
public interface RequestCertificates extends BaseTableBlock {
    interface WithRequestCertificates extends AbstractBlockElement {
        @FindBy("//h3[@id='RequestCertificates']/ancestor::fieldset")
        RequestCertificates requestCertificates();
    }
}
