package steps;

import cucumber.api.java.ru.Пусть;
import ru.lanit.at.Config;
import ru.lanit.at.exceptions.FrameworkRuntimeException;
import utils.Stand;


public class NewSampleSteps extends BaseSteps {

    @Пусть("^открываем тестируемое приложение$")
    public void openApp() {
        String url = System.getProperty("site.url", Config.loadProperty("site.url"));
        if (url == null || url.isEmpty())
            throw new FrameworkRuntimeException("Не указан стенд, установите урл для стенда выполнения");
        getDriver().get(url);
    }

    @Пусть("^открыть подсистему admin$")
    public void openAppAdminUrl() {
        openAppTwo("Admin.url");
    }

    @Пусть("^открыть браузер$")
    public void openAppBaseUrl() {
        openAppTwo("Base.url");
    }


    private void openAppTwo(String urlName) {
        String url = Stand.INSTANCE.getUrl(urlName);
        getDriver().get(url);
    }
}
