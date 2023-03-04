package steps;

import io.cucumber.java.ru.Если;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class DebugSteps extends BaseSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(DebugSteps.class);

    @Если("шаг № {string}")
    public void stepNumber(String stepNum) {
        LOGGER.info(() -> "Шаг № " + stepNum);
    }
}
