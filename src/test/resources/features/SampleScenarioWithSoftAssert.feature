# language: ru
# образец

@SampleScenarioWithSoftAssert

Функция: Sample

  Сценарий: SampleScenarioWithSoftAssert
    Дано открываем тестируемое приложение
    И перейти к странице 'Поиск яндекс'
    Затем на текущей странице перейти к блоку "Блок поиска"
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
    Тогда проверить, что в поле значение = "SampleScenarioWithSoftAssert"
    Тогда проверить, что в поле значение = 'SampleScenarioWithSoftAssert'
    Тогда проверить, что в поле значение = 'SampleScenarioWithSoftAssert'
    И очистить поле "ввода"

    И ввести в поле ввода значение "яндекс почта"
    Затем нажать на кнопку "Найти"
    И перейти к странице 'Результаты поиска'
    Затем на текущей странице перейти к блоку "Результат поисковой выдачи" - "1"
    Тогда проверить что адрес ссылки  = 'https://mail.yandex.ru/'
    Затем нажать на элемент "ссылку"
    И переключиться на новое окно 'Яндекс.Почта — бесплатная и надежная электронная почта' > c переходом на страницу 'Страница почты'
    И нажать с помощью JS на кнопку с текстом 'Создать аккаунт'
    И перейти к странице 'Регистрация почты'
    И ввести в поля ввода значения
      | Название поля             | Значение      |
      | Имя                       | Иван          |
      | Фамилия                   | Иванов        |
      | Номер мобильного телефона | 912-000-00-00 |
    И элемент "кнопка с параметрами: Подтвердить номер" отображается


