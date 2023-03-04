package utils;

import models.User;
import org.yaml.snakeyaml.Yaml;
import ru.lanit.at.exceptions.FrameworkRuntimeException;

import java.io.InputStream;
import java.util.Base64;
import java.util.Map;

public class UserUtils {

    private static final String USERS_YML = "users.yaml";

    public static User getUser(String name) {
        InputStream input = UserUtils.class.getClassLoader().getResourceAsStream(USERS_YML);
        if (input == null) {
            throw new FrameworkRuntimeException("Can not find file 'users.yaml'.");
        }
        Yaml yaml = new Yaml();
        Map<String, Object> users = yaml.load(input);
        for (String userName : users.keySet()) {
            if (userName.equalsIgnoreCase(name)) {
                Map<String, String> userMap = (Map<String, String>) users.get(userName);
                return new User(userMap.get("login"), new String(Base64.getDecoder().decode(userMap.get("pass"))));
            }
        }
        throw new FrameworkRuntimeException("User '" + name + "' not found in " + USERS_YML);
    }
}
