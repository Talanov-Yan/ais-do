package pages.aisdo.pages;

import io.qameta.atlas.webdriver.extension.FindBy;
import models.User;
import pages.html_elements.Button;
import pages.html_elements.Input;
import ru.lanit.at.pages.AbstractPage;
import ru.lanit.at.pages.annotations.Title;

/** Страница авторизации */
@Title(value = "Страница авторизации")
public interface LoginPage extends AbstractPage {

    @FindBy("//*[@name='UserName']")
    Input login();

    @FindBy("//*[@name='Password']")
    Input password();

    @FindBy("//*[@type='submit']")
    Button loginBtn();

    default void loginAs(User user) {
        login().sendKeys(user.getLogin());
        password().sendKeys(user.getPass());
        loginBtn().click();
    }
}