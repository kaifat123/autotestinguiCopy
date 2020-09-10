package dev.rusatom.qa.page;

import dev.rusatom.qa.helper.ConfProperties;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlatformPersonalOfficeLoginPage {
    private static final Logger logger = LogManager.getLogger(PlatformPersonalOfficeLoginPage.class);
    public WebDriver driver;

    public PlatformPersonalOfficeLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * локатор поля ввода логина
     */
    @FindBy(id = "username")
    private WebElement loginField;

    /**
     * локатор поля ввода пароля
     */
    @FindBy(id = "password")
    private WebElement passwdField;

    /**
     * локатор кнопки входа
     */
    @FindBy(id = "kc-login")
    private WebElement loginBtn;

    /**
     * локатор заголовка формы
     */
    @FindBy(id = "kc-page-title")
    private WebElement headline;

    /**
     * локатор названия поля логин
     */
    @FindBy(xpath = "//div/label[@for='username']")
    private WebElement nameLogin;

    /**
     * локатор названия поля пароль
     */
    @FindBy(xpath = "//div/label[@for='password']")
    private WebElement namePwd;

    /**
     * локатор чекбокса "запомнить"
     */
    @FindBy(id = "rememberMe")
    private WebElement checkboxRemember;

    /**
     * локатор ссылки сброса пароля
     */
    @FindBy(xpath = "//a[text()='Забыли пароль?']")
    private WebElement linkResetPwd;

    /**
     * локатор кнопки ЕСИА
     */
    @FindBy(id = "zocial-esia")
    private WebElement btnESIA;

    /**
     * локатор кнопки Apple-id
     */
    @FindBy(id = "zocial-apple")
    private WebElement btnAppleID;

    /**
     * локатор кнопки VK
     */
    @FindBy(id = "zocial-vk")
    private WebElement btnVkID;

    /**
     * локатор кнопки yandex
     */
    @FindBy(id = "zocial-yandex")
    private WebElement btnYandexID;

    /**
     * локатор кнопки mailRu
     */
    @FindBy(id = "zocial-mailru")
    private WebElement btnMailID;

    /**
     * локатор кнопки OK
     */
    @FindBy(id = "zocial-ok")
    private WebElement btnOkID;

    /**
     * локатор кнопки Facebook
     */
    @FindBy(id = "zocial-facebook2")
    private WebElement btnFacebookID;

    /**
     * локатор кнопки Google
     */
    @FindBy(id = "zocial-google")
    private WebElement btnGoogleID;

    /**
     * локатор ссылки Регистрации
     */
    @FindBy(xpath = "//div[@id='kc-registration']//a[text()='Регистрация']")
    private WebElement linkRegistration;

    /**
     * локатор кнопки << Назад
     */
    @FindBy(xpath = "//div[@id='kc-form-options']//a[text()='« Назад']")
    private WebElement btnBack;

    /**
     * локатор кнопки Подтвердить на форме сброса пароля
     */
    @FindBy(xpath = "//div[@id='kc-form-buttons']/input[@value='Подтвердить']")
    private WebElement btnSubmit;

    /**
     * локатор кнопки Регистрация на форме регистрации
     */
    @FindBy(xpath = "//div[@id='kc-form-buttons']/input[@value='Регистрация']")
    private WebElement btnRegistration;

    /**
     * локатор информационного поля на форме сброса пароля
     */
    @FindBy(id = "kc-info-wrapper")
    private WebElement infoWrapperDownResetPwd;

    /**
     * локатор поля Фамилия формы регистраци
     */
    @FindBy(id = "lastName")
    private WebElement lastNameField;

    /**
     * локатор поля Имя формы регистраци
     */
    @FindBy(id = "firstName")
    private WebElement firstNameField;

    /**
     * локатор поля Отчество формы регистраци
     */
    @FindBy(id = "user.attributes.middleName")
    private WebElement middleNameField;

    /**
     * локатор поля email формы регистраци
     */
    @FindBy(id = "email")
    private WebElement emailField;


    /**
     * локатор поля подтверждения пароля формы регистраци
     */
    @FindBy(id = "password-confirm")
    private WebElement passwordConfirmField;

    /**
     * локатор объекта соглашения формы регистраци
     */
    @FindBy(xpath = "//form[@id='kc-register-form']//label[@class='control-label']/a")
    private WebElement termsOfUse;

    /**
     * Метод ввода логина по-умолчанию
     */
    public void inputLogin() {
        String login = ConfProperties.getProperty("login.default");
        loginField.sendKeys(login);
        Allure.addAttachment("Значение логин ", login);
        logger.info(String.format("Введен логин: %s", login));
    }

    /**
     * Метод ввода логина с параметром
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
        Allure.addAttachment("Значение логин ", login);
        logger.info(String.format("Введен логин: %s", login));
    }
    /**
     * Метод получения объекта поля логин
     */
    public WebElement getObjectLogin() {
        logger.info("Передан объект поля логин");
        return loginField;
    }

    /**
     * Метод ввода пароля по-умолчанию
     */
    public void inputPasswd() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(passwdField));
        String pwd = ConfProperties.getProperty("password.default");
        passwdField.sendKeys(pwd);
        Allure.addAttachment("Значение пароль ", pwd);
        logger.info(String.format("Введен пароль: %s", pwd));
    }

    /**
     * Метод ввода пароля с параметром
     */
    public void inputPasswd(String pwd) {
        passwdField.sendKeys(pwd);
        Allure.addAttachment("Значение пароль ", pwd);
        logger.info(String.format("Введен пароль: %s", pwd));
    }

    /**
     * Метод нажатия кнопки вход
     */
    public void clickLoginBtn() {
        loginBtn.click();
        logger.info("Нажата кнопка входа");
    }

    /**
     * Метод для получения объекта кнопки
     */
    public WebElement getLoginBtn() {
        return loginBtn;
    }

    /**
     * Метод для получения наименования заголовка страницы авторизации
     */
    public String getHeadline(){
        logger.info("Передано наимнование заголовка страницы авторизации");
        return headline.getText();
    }

    /**
     * Метод для получения заголовка поля логин
     */
    public String getNameLoginSpace(){
        logger.info("Передано наимнование поля Логин");
        return nameLogin.getText();
    }

    /**
     * Метод для получения заголовка поля пароль
     */
    public String getNamePwdSpace(){
        logger.info("Передано наимнование поля пароль");
        return namePwd.getText();
    }

    /**
     * Метод для получения объекта чек-бокса запомнить
     */
    public WebElement getCheckboxRemember(){
        logger.info("Передан объект чек-бокса \"Запомнить\"");
        return checkboxRemember;
    }

    /**
     * Метод для получения объекта сброса пароля
     */
    public WebElement getLinkResetPwd(){
        logger.info("Передан объект ссылки \"Забыли пароль?\"");
        return linkResetPwd;
    }

    /**
     * Метод получения объекта кнопки для авторизации через ГосУслуги
     */
    public WebElement getBtnESIA(){
        logger.info("Передан объект кнопки для авторизации через ГосУслуги");
        return btnESIA;
    }

    /**
     * Метод получения объекта кнопки для авторизации через Apple
     */
    public WebElement getBtnAppleID(){
        logger.info("Передан объект кнопки для авторизации через Apple");
        return btnAppleID;
    }

    /**
     * Метод получения объекта кнопки для авторизации через VK
     */
    public WebElement getBtnVkID(){
        logger.info("Передан объект кнопки для авторизации через VK");
        return btnVkID;
    }

    /**
     * Метод получения объекта кнопки для авторизации через Yandex
     */
    public WebElement getBtnYandexID(){
        logger.info("Передан объект кнопки для авторизации через Yandex");
        return btnYandexID;
    }

    /**
     * Метод получения объекта кнопки для авторизации через Mail.ru
     */
    public WebElement getBtnMailID(){
        logger.info("Передан объект кнопки для авторизации через Mail.ru");
        return btnMailID;
    }

    /**
     * Метод получения объекта кнопки для авторизации через OK
     */
    public WebElement getBtnOkID(){
        logger.info("Передан объект кнопки для авторизации через OK");
        return btnOkID;
    }

    /**
     * Метод получения объекта кнопки для авторизации через Facebook
     */
    public WebElement getBtnFacebookID(){
        logger.info("Передан объект кнопки для авторизации через Facebook");
        return btnFacebookID;
    }

    /**
     * Метод получения объекта кнопки для авторизации через Google
     */
    public WebElement getBtnGoogleID(){
        logger.info("Передан объект кнопки для авторизации через Google");
        return btnGoogleID;
    }

    /**
     * Метод для получения объекта ссылки регистрации нового пользователя
     */
    public WebElement getLinkRegistration(){
        logger.info("Передан объект ссылки \"Регистрация\"");
        return linkRegistration;
    }

    /**
     * Метод для получения объекта кнопки Назад
     */
    public WebElement getBtnBack(){
        logger.info("Передан объект кнопки \"Назад\"");
        return btnBack;
    }

    /**
     * Метод для получения объекта кнопки Подтвердить
     */
    public WebElement getBtnSubmit(){
        logger.info("Передан объект кнопки \"Подтвердить\"");
        return btnSubmit;
    }

    /**
     * Метод для получения объекта кнопки Регистрация
     */
    public WebElement getBtnRegistration(){
        logger.info("Передан объект кнопки \"Регистрация\"");
        return btnRegistration;
    }

    /**
     * Метод для получения объекта информационного поля на форме сброса пароля
     */
    public WebElement getInfoWrapperDownResetPwd(){
        logger.info("Передан объект информационного поля на форме сброса пароля ");
        return infoWrapperDownResetPwd;
    }

    /**
     * Метод для получения объекта поля Фамилия на форме регистрации
     */
    public WebElement getLastNameField(){
        logger.info("Передан объект поля \"Фамилия\" на форме регистрации");
        return lastNameField;
    }

    /**
     * Метод для получения объекта поля Имя на форме регистрации
     */
    public WebElement getFirstNameField(){
        logger.info("Передан объект поля \"Имя\" на форме регистрации");
        return firstNameField;
    }

    /**
     * Метод для получения объекта поля Отчество на форме регистрации
     */
    public WebElement getMiddleNameField(){
        logger.info("Передан объект поля \"Отчество\" на форме регистрации");
        return middleNameField;
    }

    /**
     * Метод для получения объекта поля email на форме регистрации
     */
    public WebElement getEmailField(){
        logger.info("Передан объект поля \"email\" на форме регистрации");
        return emailField;
    }

    /**
     * Метод для получения объекта поля пароль на форме регистрации
     */
    public WebElement getPasswdField(){
        logger.info("Передан объект поля \"пароль\"");
        return passwdField;
    }

    /**
     * Метод для получения объекта поля подтверждения пароля  на форме регистрации
     */
    public WebElement getPasswordConfirmField(){
        logger.info("Передан объект поля \"подтверждения пароля\" на форме регистрации");
        return passwordConfirmField;
    }

    /**
     * Метод для получения объекта условий соглашения на форме регистрации
     */
    public WebElement getTermsOfUse(){
        logger.info("Передан объект поля \"условий соглашения\" на форме регистрации");
        return termsOfUse;
    }

    public void openStartPage() {
        String url = ConfProperties.getProperty("start.url");
        driver.get(url);
        Allure.addAttachment("Открыта страница по URL ", url);
        logger.info(String.format("Открыта страница %s", url));
    }
}
