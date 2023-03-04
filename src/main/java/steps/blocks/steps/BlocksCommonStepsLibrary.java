package steps.blocks.steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.То;
import cucumber.api.java.ru.Тогда;
import io.cucumber.java.ru.Если;
import org.openqa.selenium.Keys;
import pages.aisdo.blocks.ConfirmModalBlock;
import pages.common_blocks.BaseModalBlock;
import pages.html_elements.Button;
import pages.html_elements.CheckBox;
import io.cucumber.datatable.DataTable;
import pages.html_elements.BaseDropDown;
import pages.html_elements.Input;
import pages.html_elements.RadioButton;
import ru.yandex.qatools.matchers.webdriver.DisplayedMatcher;
import ru.yandex.qatools.matchers.webdriver.ExistsMatcher;
import steps.BaseSteps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.not;

public final class BlocksCommonStepsLibrary extends BaseSteps {

    @И("на текущей странице перейти к блоку {string}")
    public void focusOnBlock(String blockNameStr) {
        resetCurrentBlock();
        String[] blocks = blockNameStr.split(">");
        setCurrentBlockByName(blocks[0]);
        checkBlockExist();
        if (blocks.length > 1) {
            focusOnBlockInBlock(blockNameStr.substring(blockNameStr.indexOf(">") + 1));
        }
    }

    @И("в блоке {string} в выпадающем списке {string} выбрать {string}")
    public void dropdownBlock(String blockName, String dropdownName, String value) {
        resetCurrentBlock();
        setCurrentBlockByName(blockName);
        ((BaseDropDown) getElementByName(dropdownName, BaseDropDown.class)).selectByValue(value);
        resetCurrentBlock();
    }

    @И("в блоке {string} заполнить поля значениями:")
    public void fillFields(String blockName, DataTable table) {
        resetCurrentBlock();
        setCurrentBlockByName(blockName);
        List<Map<String, String>> list = table.asMaps(String.class, String.class);
        for (Map<String, String> l : list) {
            getElementByName(l.get("Название поля"), Input.class).sendKeys(l.get("Значение"));
        }
        resetCurrentBlock();
    }

    @И("в блоке {string} активировать чекбокс {string}")
    public void checkBoxTrue(String blockName, String checkbox) {
        resetCurrentBlock();
        setCurrentBlockByName(blockName);
        ((CheckBox) getElementByName(checkbox, CheckBox.class)).setChecked(true);
        resetCurrentBlock();
    }
    @И("в блоке {string} активировать радиокнопку {string}")
    public void radioButtonTrue(String blockName, String radioButton) {
        resetCurrentBlock();
        setCurrentBlockByName(blockName);
        ((RadioButton) getElementByName(radioButton,RadioButton.class)).select();
        resetCurrentBlock();
    }

    @И("на текущей странице перейти к блоку {string} - {string}")
    @Если("на текущей странице перейти к блоку {string} под названием {string}")
    public void focusOnBlockWith(String blockNameStr, String param) {
        resetCurrentBlock();
        String[] blocks = blockNameStr.split(">");
        String[] params = param.split(",");
        setCurrentBlockByName(blocks[0], params);
        checkBlockExist();
        if (blocks.length > 1) {
            focusOnBlockInBlock(blockNameStr.substring(blockNameStr.indexOf(">") + 1));
        }
    }

    @И("^в текущем блоке перейти к блоку '(.*)'$")
    public void focusOnBlockInBlock(String blockNameStr) {
        Arrays.stream(blockNameStr.split(">"))
                .forEach(blockName -> {
                    setCurrentBlockByName(blockName.trim());
                    checkBlockExist();
                });
    }

    @И("проверить что блок отображается")
    public void checkBlockVisible() {
        getCurrentBlock().should(DisplayedMatcher.displayed(), 10);
    }

    @И("проверить что на странице отображется блок {string} под названием {string}")
    public void checkBlockVisible(String blockNameStr, String param) {
        resetCurrentBlock();
        setCurrentBlockByName(blockNameStr, param);
        checkBlockVisible();
        resetCurrentBlock();
    }

    @И("проверить что блок существует")
    public void checkBlockExist() {
        getCurrentBlock().should(ExistsMatcher.exists(), 10);
    }

    @И("проверить что блок отсуствует")
    public void checkBlockNotExist() {
        getCurrentBlock().should(not(ExistsMatcher.exists()), 10);
    }

    @И("в блоке {string} заполнить поле {string} значением {string}")
    public void fillField(String blockName, String inputName, String text) {
        resetCurrentBlock();
        setCurrentBlockByName(blockName);
        Input input = getElementByName(inputName,Input.class);
        input.clear();
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
        resetCurrentBlock();
    }

    @И("в блоке {string} поле {string} заполнено значением {string}")
    public void checkInputName(String blockName, String inputName, String text) {
        resetCurrentBlock();
        setCurrentBlockByName(blockName);
        String textInput = getElementByName(inputName,Input.class).getAttribute("value");
        softAssert().assertTrue(textInput.contains(text), "Текст в поле '" + textInput + "'. Не содержит текст: '" + text + "'");
        resetCurrentBlock();
    }

    @Тогда("текущий блок содержит текст {string}")
    public void assertBlockHasText(String expectedText) {
        String actualText = getCurrentBlock().getText();
        softAssert().assertTrue(actualText.toLowerCase().contains(expectedText.toLowerCase()), "Текст в блоке '" + actualText + "'. Не содержит текст: '" + expectedText + "'");
    }

    @То("всплывающее окно с заголовком {string} отображается")
    public void shouldBeElement(String blockTitle) {
        resetCurrentBlock();
        setCurrentBlock(BaseModalBlock.class, blockTitle);
        checkBlockVisible();
    }
}