package steps;

import cucumber.api.java.ru.И;

public class DeprecatedSteps extends BaseSteps {
    /**
     * @deprecated предлагаю удалить и не использовать этот и подобные методы, так как они создают дополнительный
     * слой абстракции который сложно понимать и поддерживать
     */
    @И("выполнить действие {string}")
    public void executeMethod(String methodName) {
        executeMethodByName(getSearchContext(), methodName);
    }

    /**
     * @deprecated предлагаю удалить и не использовать этот и подобные методы, так как они создают дополнительный
     * слой абстракции который сложно понимать и поддерживать
     */
    @И("выполнить действие {string}, c аргументами {string}")
    public void executeMethod(String methodName, String arg) {
        executeMethodByName(getSearchContext(), methodName, arg);
    }
}
