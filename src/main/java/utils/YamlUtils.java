package utils;

import org.yaml.snakeyaml.Yaml;
import ru.lanit.at.exceptions.FrameworkRuntimeException;

import java.io.InputStream;
import java.util.Map;

public class YamlUtils {
    public static Map<String, Object> getResource(String fileName) {
        InputStream input = UserUtils.class.getClassLoader().getResourceAsStream(fileName);
        if (input == null) {
            throw new FrameworkRuntimeException("Can not find file '" + fileName + "' in resources dir.");
        }
        Yaml yaml = new Yaml();
        return yaml.load(input);
    }
}
