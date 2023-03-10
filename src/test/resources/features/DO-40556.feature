# language: ru
# Щукин А.А. 07.09.2022

@smoke
Функционал: Менеджер

  Предыстория:

    * открыть браузер

  @C23
  Сценарий: 23. Проверка возможности формирования и управления заездами

    * шаг № "1"
    И авторизоваться в системе с ролью "Менеджер"
    И пользователь на странице "Главная страница"

    * шаг № "2"
    И в выпадающем списке "Заезды" выбрать "Реестр отправок"
    И открыта страница "Реестр заездов"

    * шаг № "3"
    И в выпадающем списке "Год кампании" выбрать "2016"
    И в выпадающем списке "Статус" выбрать "Редактирование"
    И нажать на кнопку с текстом "Поиск"
    И в таблице в строке, содержащей "Редактирование", нажать на "иконка Карандаша"

    * шаг № "4"
    И переключиться на следующую вкладку
    И открыта страница "Заезд"
    И дождаться появления ссылки "Персонал"
    И нажать на ссылку с текстом "Персонал"

    * шаг № "5"
    И нажать на элемент с названием "Администраторы смены +"
    И на текущей странице перейти к блоку "Администраторы"
    И всплывающее окно с заголовком "Администраторы" отображается
    И в таблице "Список персонала" в строке, содержащей "Аветисян Тамара Кареновна", нажать на кнопку "Добавить"
    И на текущей странице перейти к блоку "Администраторы"
    И нажать на кнопку с текстом "Закрыть"

    * шаг № "6"
    И открыта страница "Заезд"
    И дождаться появления кнопки "Сохранить"
    И нажать на кнопку с текстом "Сохранить"
    И в таблице "Администраторы смены" текст "Аветисян Тамара Кареновна" присутствует