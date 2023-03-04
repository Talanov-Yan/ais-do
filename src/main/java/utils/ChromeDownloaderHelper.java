package utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Class provides functionality to get downloaded files names by using Chrome browser capabilities chrome://downloads/
 */

public class ChromeDownloaderHelper {
    private static final Logger LOGGER = Logger.getLogger(ChromeDownloaderHelper.class.getName());

    private static final long MAX_GET_FILE_NAME_ATTEMPT = 10;

    public static String getLastDownloadedFilename(WebDriver driver) throws Exception {
        String[] filename = new String[1];
        Exception[] ex = new Exception[1];
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.open('','_blank');");
        Set<String> newTabs = driver.getWindowHandles();
        String currentWindowHandle = driver.getWindowHandle();
        for (String tab : newTabs) {
            if (!currentWindowHandle.equals(tab)) {
                driver.switchTo().window(tab);
            }
        }
        driver.get("chrome://downloads/");
        for (int i = 0; i < MAX_GET_FILE_NAME_ATTEMPT; i++) {
            ex[0] = null;
            sleep();
            try {
                WebElement element = (WebElement) executor.executeScript(
                        "return document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-item').shadowRoot.getElementById('file-link')");
                filename[0] = element.getText();
                LOGGER.info("Attempt get file name " + i + ". Name = '" + filename[0] + "'");
            } catch (WebDriverException e) {
                ex[0] = e;
                LOGGER.info("Failed attempt " + i + " to get filename text: " + e.getMessage());
                continue;
            }
            if (filename[0] != null && !filename[0].isEmpty()) {
                removeLastDownloadedFileName(executor);
                closeWindowsAndSwitch(driver);
                break;
            }
        }

        if (filename[0] != null && !filename[0].isEmpty()) {
            return filename[0];
        }

        String message = "Timeout. Can not get last downloaded file name from chrome://downloads/. File name is '" + filename[0] + "'.";
        if (ex[0] != null) {
            LOGGER.warning(message + " Cause: " + ex[0].getMessage());
            throw new Exception(message, ex[0]);
        } else {
            LOGGER.warning(message);
            throw new Exception(message);
        }
    }

    private static void closeWindowsAndSwitch(WebDriver driver) {
        ArrayList<String> newTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTabs.get(1));
        driver.close();
        driver.switchTo().window(newTabs.get(0));
    }

    private static void removeLastDownloadedFileName(JavascriptExecutor executor) {
        executor.executeScript(
                "document.querySelector('downloads-manager').shadowRoot.querySelector('downloads-item').shadowRoot.getElementById('remove').click()");
    }

    // It needs for prevent situation with returning empty string as file name by chrome downloads page
    private static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e2) {
            throw new RuntimeException("InterruptedException!!! Can not get downloaded filename." + e2.getMessage(), e2);
        }
    }

    public static ArrayList<String> getDownloadFilesName(WebDriver driver) {
        ArrayList<String> result = new ArrayList<>();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.get("chrome://downloads/");
        List<WebElement> elements = (List<WebElement>) executor.executeScript(
                "var arr = [];" +
                        "document.querySelector('downloads-manager').shadowRoot.querySelectorAll('downloads-item').forEach(function(element){arr.push(element.shadowRoot.getElementById('file-link'));});" +
                        "return arr;");
        for (WebElement element : elements) {
            result.add(element.getText());
        }
        return result;
    }

    public static String removeIndex(String file) {
        String fileName = FilenameUtils.getBaseName(file);
        String newFileName = fileName.replaceAll(" \\(\\d\\)$", "");
        String result = file.replace(fileName, newFileName);
        if (!result.equals(file))
            LOGGER.info(String.format("Имя скачанного файла '%s' в ГИС ЖКХ будет отображаться как '%s'", file, result));
        return result;
    }
}
