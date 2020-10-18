# language: ru
@smoke @smokeFe26
Функционал: Авторизация в личном кабинете

  @TmsLink=PLATFORM-T2 @Issue=PLATFORM-82 @flaky @severity=blocker
  Сценарий: Проверка наличия всех элементов на странице авторизации
    * Открываем стартовую страницу личного кабинета
    * Проверить, что title страницы равен "Вход в систему"
    * Проверить, что заголовок страницы авторизации равен "Войти"
    * Проверить, что наименование поля логин равен "Электронная почта / Логин"
    * Проверить, что наименование поля пароль равен "Пароль"
    * "Проверить наличие" чек-бокса "Запомнить"
    * "Проверить наличие" ссылки "Забыли пароль?"
    * "Проверить наличие" кнопки для авторизации через соц.сеть "ЕСИА"
    * "Проверить наличие" кнопки для авторизации через соц.сеть "Apple"
    * "Проверить наличие" кнопки для авторизации через соц.сеть "VK"
    * "Проверить наличие" кнопки для авторизации через соц.сеть "Yandex"
    * "Проверить наличие" кнопки для авторизации через соц.сеть "Mail.ru"
    * "Проверить наличие" кнопки для авторизации через соц.сеть "OK"
    * "Проверить наличие" кнопки для авторизации через соц.сеть "Facebook"
    * "Проверить наличие" кнопки для авторизации через соц.сеть "Google"
    * "Проверить наличие" ссылки "Регистрация"


