package steps.browser.steps;


import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import ru.lanit.at.exceptions.FrameworkRuntimeException;
import ru.lanit.at.pages.AbstractPage;
import steps.BaseSteps;
import utils.data.helpers.DataRandomGenerator;

import java.util.ArrayList;
import java.util.Set;

import static utils.ChromeDownloaderHelper.getLastDownloadedFilename;


public final class CommonStepsBrowserLibrary extends BaseSteps {
    @И("обновить страницу браузера")
    public void clickButtonWithText() {
        getDriver().navigate().refresh();
    }

    @Дано("перейти по адресу {string}")
    public void openPage(String url) {
        getDriver().get(DataRandomGenerator.replaceAllGeneratingValues(url));
    }

    @И("переключиться на следующую вкладку")
    public void switchesToNextPage() {
        WebDriver driver = getDriver();
        Set<String> newTabs = driver.getWindowHandles();
        String currentWindowHandle = driver.getWindowHandle();
        for (String tab : newTabs) {
            // todo: метод должен переходить на следующую по порядку вкладку, а не на первую отличающуюся от  текущей
            if (!currentWindowHandle.equals(tab)) {
                driver.switchTo().window(tab);
            }
        }
    }

    @И("^перейти к странице '(.*)'$")
    @Если("пользователь на странице {string}")
    public void changePageTo(String pageTitle) {
        getPageByTitle(pageTitle);
        resetCurrentBlock();
    }

    @Тогда("открыта страница {string}")
    public void isPageOpen(String pageTitle) {
        resetCurrentBlock();
        AbstractPage page = getPageByTitle(pageTitle);
        softAssert().assertTrue(page.isOpen(), "Страница '" + pageTitle + "' не открыта");
    }

    @И("^вернуться к странице$")
    public void returnToPage() {
        resetCurrentBlock();
    }

    @И("проверить, что тайтл страницы = {string}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = getCurrentPage().getWrappedDriver().getTitle();
        softAssert().assertTrue(expectedTitle.equalsIgnoreCase(actualTitle), "Ожидалось что тайтл страницы '" + expectedTitle + "', фактически:'" + actualTitle + "'");
    }

    @И("^переключиться на новое окно > c переходом на страницу '(.*)'$")
    public void switchToNewPage(String pageTitle) {
        switchToWindow(pageTitle);
        changePageTo(pageTitle);
    }

    /**
     * Switch driver focus to window/tab and change current page in PageCatalog
     *
     * @param pageTitle - title window/tab
     * @param pageName  -  page by title{@link ru.lanit.at.pages.annotations.Title
     */
    @И("^переключиться на новое окно '(.*)' > c переходом на страницу '(.*)'$")
    public void switchToWindow(String pageTitle, String pageName) {
        switchToWindow(pageTitle);
        changePageTo(pageName);
    }

    private void switchToWindow(String pageTitle) {
        WebDriver webDriver = getDriver();
        String initialTabId = webDriver.getWindowHandle();
        String newTabId = getNewTabId(pageTitle);
        webDriver.switchTo().window(initialTabId);
        webDriver.close();
        webDriver.switchTo().window(newTabId);
    }

    private String getNewTabId(String pageTitle) {
        WebDriver driver = getDriver();
        Set<String> newTabs = driver.getWindowHandles();
        for (String tab : newTabs) {
            driver.switchTo().window(tab);
            if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
                return tab;
            }
        }
        throw new FrameworkRuntimeException("Не найдена вкладка с именем " + pageTitle);
    }

    @И("закрыть текущую вкладку и перейти на предыдущую")
    public void closeWindowsAndSwitch() {
        WebDriver driver = getDriver();
        ArrayList<String> newTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTabs.get(1));
        driver.close();
        driver.switchTo().window(newTabs.get(0));
    }

    @И("выгружен файл с названием {string}")
    public void checkDownloadedPage(String name) throws Exception {
        String fileName = getLastDownloadedFilename(getDriver());
        softAssert().assertTrue(fileName.contains(name));
    }

}