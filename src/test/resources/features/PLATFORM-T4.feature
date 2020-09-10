# language: ru
@smoke @test
Функционал: Авторизация в личном кабинете

  @TmsLink=PLATFORM-T4 @Issue=PLATFORM-82 @severity=blocker
  Сценарий: Проверка наличия всех элементов на форме регистрации
    * Открываем стартовую страницу личного кабинета
    * "Нажать" ссылку "Регистрация"
    * Проверить, что title страницы равен "Вход в систему"
    * Проверить, что заголовок страницы авторизации равен "Регистрация"
    * Проверить, что поле ввода "Имя" отображается
    * Проверить, что поле ввода "Фамилия" отображается
    * Проверить, что поле ввода "Отчество" отображается
    * Проверить, что поле ввода "Email" отображается
    * Проверить, что поле ввода "Пароль" отображается
    * Проверить, что поле ввода "Подтверждение Пароля" отображается
    * "Проверить наличие" кнопки "Назад"
    * "Проверить наличие" кнопки "Регистрация"
    * Проверить, что отображается ссылка на условия соглашения на странице регистрации