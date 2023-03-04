# language: ru

@smoke
Функционал: ОИВ

  Предыстория:
    * открыть браузер

  @C30
  Сценарий: 30. Проверка возможности работы с квотами по учреждениям:
  перевод в статус «Доведены до организации/формирование списка».
  перевод в статус «На доработку».
  перевод в статус «Утверждено».
  перевод в статус «Формирование»

    * шаг № "1"
    И авторизоваться в системе с ролью "ОИВ"
    И пользователь на странице "Главная страница"

    * шаг № "2"
    И в выпадающем списке "Льготники/Профильники" выбрать "Квоты учреждения"
    И открыта страница "Квоты по учреждениям"

    * шаг № "3"
    И в выпадающем списке "Год кампании:" выбрать "2017"
    И нажать на элемент с названием "I смена"
    И в таблице "Список учреждений" в строке, содержащей "Подтверждено ДКгМ", в столбце 1 нажать на элемент
    И открыта страница "Заявки от учреждений (списки детей)"

    * шаг № "4"
    И нажать на кнопку с текстом "Вернуть на утверждение"
    И всплывающее окно с заголовком "Подтвердить действие" отображается
    И нажать на кнопку с текстом "Вернуть на утверждение"
    И открыта страница "Заявки от учреждений (списки детей)"
    И на странице присутствует текст "Статус: Отправлена на утверждение в ОИВ"

    * шаг № "5"
    И нажать на кнопку с текстом "На доработку"
    И всплывающее окно с заголовком "Подтвердить действие" отображается
    И нажать на кнопку с текстом "На доработку"
    И открыта страница "Заявки от учреждений (списки детей)"
    И на странице присутствует текст "Статус: На доработку"

    * шаг № "6"
    И нажать на кнопку с текстом "Редактировать списки"
    И всплывающее окно с заголовком "Подтвердить действие" отображается
    И нажать на кнопку с текстом "Редактировать списки"
    И открыта страница "Заявки от учреждений (списки детей)"
    И на странице присутствует текст "Статус: Доведены до организации/ Формирование списков"

    * шаг № "7"
    И нажать на кнопку с текстом "Отправить на утверждение"
    И всплывающее окно с заголовком "Подтвердить действие" отображается
    И нажать на кнопку с текстом "Отправить на утверждение"
    И открыта страница "Заявки от учреждений (списки детей)"
    И на странице присутствует текст "Статус: Отправлена на утверждение в ОИВ"

    * шаг № "8"
    И нажать на кнопку с текстом "Утвердить"
    И всплывающее окно с заголовком "Подтвердить действие" отображается
    И нажать на кнопку с текстом "Утвердить"
    И открыта страница "Заявки от учреждений (списки детей)"
    И на странице присутствует текст "Статус: Утверждено"

    * шаг № "9"
    И нажать на кнопку с текстом "Подтвердить"
    И всплывающее окно с заголовком "Подтвердить действие" отображается
    И нажать на кнопку с текстом "Подтвердить"
    И открыта страница "Заявки от учреждений (списки детей)"
    И на странице присутствует текст "Подтверждено ДКгМ"