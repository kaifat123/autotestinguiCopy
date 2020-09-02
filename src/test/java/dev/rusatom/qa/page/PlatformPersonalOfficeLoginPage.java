package dev.rusatom.qa.page;

import dev.rusatom.qa.helper.ConfProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlatformPersonalOfficeLoginPage {
    private static Logger logger = LogManager.getLogger(PlatformPersonalOfficeLoginPage.class);
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
     * Метод ввода логина по-умолчанию
     */
    public void inputLogin() {
        String login = ConfProperties.getProperty("login.default");
        loginField.sendKeys(login);
        logger.info(String.format("Введен логин: %s", login));
    }

    /**
     * Метод ввода логина с параметром
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
        logger.info(String.format("Введен логин: %s", login));
    }

    /**
     * Метод ввода пароля по-умолчанию
     */
    public void inputPasswd() {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(passwdField));
        String pwd = ConfProperties.getProperty("password.default");
        passwdField.sendKeys(pwd);
        logger.info(String.format("Введен пароль: %s", pwd));
    }

    /**
     * Метод ввода пароля с параметром
     */
    public void inputPasswd(String pwd) {
        passwdField.sendKeys(pwd);
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


    public void openStartPage() {
        String url = ConfProperties.getProperty("start.url");
        driver.get(url);
        logger.info(String.format("Открыта страница %s", url));
    }
}
