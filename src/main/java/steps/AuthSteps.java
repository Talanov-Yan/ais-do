package steps;

import io.cucumber.java.ru.Дано;
import models.User;
import pages.aisdo.pages.LoginPage;
import utils.UserUtils;

public class AuthSteps extends BaseSteps {

    public static final String USER = "user";

    @Дано("авторизоваться в системе с ролью {string}")
    public void auth(String roleName) {
        getPage(LoginPage.class);
        User user = UserUtils.getUser(roleName);
        saveTestData(USER, user);
        ((LoginPage) getCurrentPage()).loginAs(user);
    }

}
