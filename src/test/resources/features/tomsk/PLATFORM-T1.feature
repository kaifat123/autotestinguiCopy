# language: ru
@smoke @smokeTomsk
Функционал: Авторизация в личном кабинете

  @TmsLink=PLATFORM-T1 @Issue=PLATFORM-82 @severity=blocker
  Сценарий: Авторизация по умолчанию
    Когда Открываем стартовую страницу личного кабинета
    И Вводим логин "по-умолчанию"
    И Вводим пароль "по-умолчанию"
    Затем Нажимаем кнопку Войти
    Тогда Проверить что заголовок страницы личного кабинета равен "Мой профиль"