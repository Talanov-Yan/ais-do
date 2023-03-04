package utils;

import ru.lanit.at.Config;
import ru.lanit.at.exceptions.FrameworkRuntimeException;

import java.util.Map;

public enum Stand {
    INSTANCE;

    private static final String STANDS_YML = "stands.yaml";

    private final Map<String, String> stand;

    Stand() {
        String standType = System.getProperty("site.url", Config.loadProperty("site.url"));
        stand = getStandUrls(standType);
    }

    public String getUrl(String urlName) {
        String url = stand.get(urlName);
        if (url == null || url.isEmpty()) {
            throw new FrameworkRuntimeException("Не указан стенд " + stand);
        }
        return url;
    }

    private Map<String, String> getStandUrls(String standType) {
        Object result = YamlUtils.getResource(STANDS_YML).get(standType);
        if (result == null) {
            throw new FrameworkRuntimeException("В файле " + STANDS_YML + " не найден тип стенда: " + standType);
        }
        return (Map<String, String>) result;
    }
}
