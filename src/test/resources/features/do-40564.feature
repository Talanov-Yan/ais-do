# language: ru

@smoke
Функционал: Отдел транспортного обеспечения

  Предыстория:

    * открыть браузер

  @C31
  Сценарий: 31. Проверка возможности работы с рейсами:
  перевод рейса в статус «Сформирован»;
  перевод рейса в статус «Формирование»

    * шаг № "1"
    И авторизоваться в системе с ролью "Отдел транспортного обеспечения"
    И пользователь на странице "Главная страница"

    * шаг № "2"
    И в выпадающем списке "Заезды" выбрать "Реестр рейсов"
    И открыта страница "Реестр рейсов"

    * шаг № "3"
    И в выпадающем списке "Год кампании" выбрать "2015"
    И нажать на кнопку с текстом "Поиск"

    * шаг № "4"
    И в таблице в строке, содержащей "Сформирован", нажать на "иконку Карандаша"

    * шаг № "5"
    И переключиться на следующую вкладку
    И открыта страница "Рейс"
    И нажать на кнопку с текстом "Редактировать рейс"
    И всплывающее окно с заголовком "Подтвердить действие" отображается
    И нажать на кнопку с текстом "Редактировать рейс"
    И открыта страница "Рейс"
    И на странице присутствует текст "Статус: Формирование"

    * шаг № "6"
    И заполнить поле "Транспортный узел отбытия" значением "100"

    * шаг № "7"
    И нажать на кнопку с текстом "Сохранить"

    * шаг № "8"
    И нажать на кнопку с текстом "Сформировать рейс"
    И всплывающее окно с заголовком "Подтвердить действие" отображается
    И нажать на кнопку с текстом "Сформировать рейс"
    И открыта страница "Рейс"
    И на странице присутствует текст "Статус: Сформирован"