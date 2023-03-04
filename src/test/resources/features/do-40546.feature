# language: ru
# Куликова 26.07.2022

@smoke

Функция:  Администратор системы

  Предыстория:

    * открыть подсистему admin

  @C13
  Сценарий: 13. Проверка возможности создания роли

    * шаг № "1"
    И авторизоваться в системе с ролью "Администратор"
    И пользователь на странице "Главная страница"

    * шаг № "2"
    И в выпадающем списке "Настройки безопасности" выбрать "Роли"
    И открыта страница "Роли пользователей"
    И кнопка "Добавить роль" присутствует
    И на текущей странице перейти к блоку "Поиск ролей"
    И поле с текстом "Название роли" присутствует
    И кнопка с текстом "Поиск" присутствует
    И кнопка "Очистить фильтр" присутствует
    И открыта страница "Роли пользователей"
    И в таблице присутствуют столбцы:
      | №             |
      | Название роли |
    И элемент "иконка Карандаша" присутствует
    И элемент "иконка Корзины" присутствует
    И на странице присутствует текст "Всего записей"

    * шаг № "3"
    И нажать кнопку "Добавить роль"
    И переключиться на следующую вкладку
    И открыта страница "Роль"
    И поле с текстом "Название роли" присутствует
    И кнопка с текстом "Назначить" присутствует


    * шаг № "4"
    И заполнить поле "Название роли" значением "Уникальная роль260722"
    И поле с текстом "Название роли" заполнено значением "Уникальная роль260722"

    * шаг № "5"
    И нажать на кнопку с текстом "Назначить"
    И активировать чекбокс c текстом "(ИБ) Журнал сеансов (сессий). Просмотр."
    И чекбокс c текстом "(ИБ) Журнал сеансов (сессий). Просмотр." активирован
    И нажать на кнопку с текстом "Назначить"

    * шаг № "6"
    И нажать на кнопку с текстом "Сохранить"
    И поле с текстом "Название роли" заполнено значением "Уникальная роль260722"

    * шаг № "7"
    И в выпадающем списке "Настройки безопасности" выбрать "Роли"
    И открыта страница "Роли пользователей"

    * шаг № "8"
    И заполнить поле "Название роли" значением "Уникальная роль260722"
    И поле с текстом "Название роли" заполнено значением "Уникальная роль260722"

    * шаг № "9"
    И нажать на кнопку с текстом "Поиск"
    И в таблице в строке 1 в столбце 2 текст "Уникальная роль260722" присутствует
    И элемент "иконка Корзины" присутствует

    * шаг № "10"
    И нажать на кнопку "иконка Корзины"
    И в таблице присутствуют столбцы:
      | №             |
      | Название роли |
    И элемент "иконка Карандаша" присутствует
    И элемент "иконка Корзины" присутствует
    И на странице присутствует текст "Всего записей"

    * шаг № "11"
    И заполнить поле "Название роли" значением "Уникальная роль260722"
    И поле с текстом "Название роли" заполнено значением "Уникальная роль260722"

    * шаг № "12"
    И нажать на кнопку с текстом "Поиск"
    И на странице присутствует текст "Поиск не дал результатов"