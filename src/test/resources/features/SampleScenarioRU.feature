# language: ru
# образец
@SampleScenarioRu

Функция: Sample

  Сценарий: SampleScenarioRU
    Дано открываем тестируемое приложение
    И перейти к странице 'Поиск_яндекс'
    Затем на текущей странице перейти к блоку "Поисковый_блок"
    И ввести в поле ввода дату "сегодня + 12 лет"
    И очистить поле "ввода"
    И ввести в поле ввода дату "сегодня + 10 дней"
    И очистить поле "ввода"
    И ввести в поле ввода дату "сегодня - 10 недель"
    И очистить поле "ввода"
    И ввести в поле ввода дату "сегодня + 1 месяц"
    И очистить поле "ввода"
    И ввести в поле ввода дату "сегодня"
    И очистить поле "ввода"

    И ввести в поле ввода значение "яндекс почта"
    Затем нажать на кнопку с текстом 'Найти'
    И перейти к странице 'Результаты_поиска'
    Затем на текущей странице перейти к блоку "Блок_с_результатами_поисковой_выдачи" - "1"
    Тогда проверить что адрес ссылки  = 'https://mail.yandex.ru/'
    Затем нажать на элемент "ссылку"
    И переключиться на новое окно 'Яндекс.Почта — бесплатная и надежная электронная почта' > c переходом на страницу 'Яндекс_почта'
    И нажать с помощью JS на кнопку с текстом 'Создать аккаунт'
    И перейти к странице 'Яндекс_регистрация_почты'
    И ввести в поля ввода значения
      | Название поля             | Значение      |
      | Имя                       | Иван          |
      | Фамилия                   | Иванов        |
      | Номер мобильного телефона | 912-000-00-00 |
    И элемент "кнопка с параметрами: Подтвердить номер" отображается