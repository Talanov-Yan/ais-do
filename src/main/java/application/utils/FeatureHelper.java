package application.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class FeatureHelper {
    private static final Logger logger = LoggerFactory.getLogger(FeatureHelper.class);
    public static String PATH = "features/";

    /** Создание  папки с для feature  файла */
    public String createFeaturePath(Long uuid) {
        String path = PATH + uuid + "/";
        new File(new File(path).getAbsolutePath()).mkdirs();
        return path;
    }
}