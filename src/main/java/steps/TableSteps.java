package steps;

import cucumber.api.java.ru.И;
import io.cucumber.java.ru.Если;
import io.qameta.atlas.webdriver.AtlasWebElement;
import pages.common_blocks.BaseTableBlock;
import pages.common_blocks.BaseTableCellBlock;
import pages.common_blocks.BaseTableRowBlock;
import ru.yandex.qatools.matchers.webdriver.ExistsMatcher;

import java.util.List;

public class TableSteps extends BaseSteps {

    @И("в таблице {string} присутствуют столбцы:")
    public void checkTableColumns(String tableName, List<String> columns) {
        resetCurrentBlock();
        setCurrentBlockByName(tableName);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock header = ((BaseTableBlock) getCurrentBlock()).rowHeader();
        columns.forEach(column -> softAssert().assertTrue(header.allCells().stream()
                        .anyMatch(cell -> cell.getText().equals(column)),
                "В таблице '" + tableName + "' не найден столбец '" + column + "'"
                )
        );
        resetCurrentBlock();
    }

    @И("в таблице присутствуют столбцы:")
    public void checkTableColumnsTwo(List<String> columns) {
        resetCurrentBlock();
        setCurrentBlock(BaseTableBlock.class);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock header = ((BaseTableBlock) getCurrentBlock()).rowHeader();
        columns.forEach(column -> softAssert().assertTrue(header.allCells().stream()
                        .anyMatch(cell -> cell.getText().equals(column)),
                "В таблице не найден столбец '" + column + "'"
                )
        );
        resetCurrentBlock();
    }

    @И("в таблице в строке содержащей {string} нажать на элемент {icon}")
    public void btnEditIcon(String text, String iconClass) {
        resetCurrentBlock();
        setCurrentBlock(BaseTableBlock.class);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = table.rowWithText(text);
        row.iconWithClass(iconClass).click();
        resetCurrentBlock();
    }

    // есть новый метод clickElement
    @Deprecated
    @И("в таблице {string} в строке, содержащей {string}, в столбце {int} нажать на элемент")
    public void clickOnTheLink(String tableName, String text, int column) {
        resetCurrentBlock();
        setCurrentBlockByName(tableName);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = ((BaseTableBlock) getCurrentBlock()).rowWithText(text);
        softAssert().assertTrue(row.getText().contains(text));
        if (row.getText().contains(text)) {
            row.columnIndex(column).btnLink().click();
        }
        resetCurrentBlock();
    }
    @И("в таблице в строке содержащей {string} в столбце {int} нажать на ссылку")
    public void clickOnTheLinkTwo(String text, int column) {
        resetCurrentBlock();
        setCurrentBlock(BaseTableBlock.class);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = ((BaseTableBlock) getCurrentBlock()).rowWithText(text);
        softAssert().assertTrue(row.getText().contains(text));
        if (row.getText().contains(text)) {
            row.columnIndex(column).btnLink().click();
        }
        resetCurrentBlock();
    }

    // Deprecated: шаг ищет элемент таблицы по тайтлу, поэтому следует использовать соответствующую формулировку
    @И("в таблице {string} в строке {int} нажать на элемент {string}")
    @Если("в таблице {string} в строке {int} нажать на элемент с тайтлом {string}")
    public void btnIconInRow(String tableName, int indexRow, String elementName) {
        resetCurrentBlock();
        setCurrentBlockByName(tableName);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = ((BaseTableBlock) getCurrentBlock()).rowOnIndex(indexRow);
        row.iconWithTitle(elementName).click();
        resetCurrentBlock();
    }

    @И("в таблице {string} в строке, содержащей {string}, нажать на элемент c тайтлом {string}")
    public void clickElement(String tableName, String text, String elementName) {
        resetCurrentBlock();
        setCurrentBlockByName(tableName);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = ((BaseTableBlock) getCurrentBlock()).rowWithText(text);
        row.iconWithTitle(elementName).click();
        resetCurrentBlock();
    }

    @И("в таблице {string}, в строке {int}, нажать на элемент {icon}")
    public void clickIcon(String tableName, int rowNumber, String iconName) {
        resetCurrentBlock();
        setCurrentBlockByName(tableName);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = ((BaseTableBlock) getCurrentBlock()).rowOnIndex(rowNumber);
        row.iconWithClass(iconName).click();
        resetCurrentBlock();
    }

    @И("в таблице в строке {int} в столбце {int} текст {string} присутствует")
    public void checkText(int rowIndex, int columnIndex, String text) {
        resetCurrentBlock();
        setCurrentBlock(BaseTableBlock.class);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = table.rowOnIndex(rowIndex);
        BaseTableCellBlock cell = row.columnIndex(columnIndex);
        String actualText = cell.getText();
        softAssert().assertTrue(actualText != null && actualText.contains(text),
                String.format("В таблице, строке %d, столбце %d не содержится текст '%s'", rowIndex, columnIndex, text));
        resetCurrentBlock();
    }

    @io.cucumber.java.ru.И("в таблице {string} в строке {int} в столбце {int} текст {string} присутствует")
    public void checkText(String tableName, int rowIndex, int columnIndex, String text) {
        resetCurrentBlock();
        setCurrentBlockByName(tableName);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = table.rowOnIndex(rowIndex);
        BaseTableCellBlock cell = row.columnIndex(columnIndex);
        String actualText = cell.getText();
        softAssert().assertTrue(actualText != null && actualText.contains(text),
                String.format("В таблице '%s', строке %d, столбце %d не содержится текст '%s'", tableName, rowIndex, columnIndex, text));
        resetCurrentBlock();
    }

    @io.cucumber.java.ru.И("в таблице {string} в строке, содержащей {string}, в столбце {int} нажать на элемент {icon}")
    public void btnEditIcon(String tableName, String text, int cellNumber, String iconClass) {
        resetCurrentBlock();
        setCurrentBlockByName(tableName);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = table.rowWithText(text);
        BaseTableCellBlock cell = row.columnIndex(cellNumber);
        cell.iconWithClass(iconClass).click();
        resetCurrentBlock();
    }

    @io.cucumber.java.ru.И("в таблице в строке, содержащей {string}, нажать на {icon}")
    public void clickOnTableElementInRowWithText(String text, String iconClass) {
        resetCurrentBlock();
        setCurrentBlock(BaseTableBlock.class);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = table.rowWithText(text);
        row.iconWithClass(iconClass).click();
        resetCurrentBlock();
    }

    //Для таблиц с ссылками в ячейках
    @И("в таблице в строке {int} в столбце {int} нажать на ссылку")
    public void сlickLinkInTable(int rowNumber, int columnNumber) {
        resetCurrentBlock();
        setCurrentBlock(BaseTableBlock.class);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = table.rowOnIndex(rowNumber);
        row.columnIndex(columnNumber).click();
    }

    @io.cucumber.java.ru.И("в таблице {string} в строке, содержащей {string}, нажать на {type} {string}")
    public void clickOnTableElementInRowWithText(String tableName, String text, Class<? extends AtlasWebElement> type, String elementName) {
        resetCurrentBlock();
        setCurrentBlockByName(tableName);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = table.rowWithText(text);
        row.buttonWithText(elementName).click();
        resetCurrentBlock();
    }

    @io.cucumber.java.ru.И("в таблице в строке, содержащей {string}, нажать на {type} {string}")
    public void clickOnTableButtonInRowWithText(String text, Class<? extends AtlasWebElement> type, String elementName) {
        resetCurrentBlock();
        setCurrentBlock(BaseTableBlock.class);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = ((BaseTableBlock) getCurrentBlock()).rowWithText(text);
        row.getElement(elementName, type).click();
        resetCurrentBlock();
    }

    @io.cucumber.java.ru.И("в таблице {string} текст {string} присутствует")
    public void вТаблицеТекстПрисутствует(String tableName, String text) {
        resetCurrentBlock();
        setCurrentBlockByName(tableName);
        BaseTableBlock table = ((BaseTableBlock) getCurrentBlock());
        table.should(ExistsMatcher.exists(), 60);
        BaseTableRowBlock row = ((BaseTableBlock) getCurrentBlock()).rowWithText(text);
        softAssert().assertTrue(row.getText() != null && row.getText().contains(text),
                String.format("В таблице '%s' не содержится текст '%s'", tableName, text));
        resetCurrentBlock();
    }
}
