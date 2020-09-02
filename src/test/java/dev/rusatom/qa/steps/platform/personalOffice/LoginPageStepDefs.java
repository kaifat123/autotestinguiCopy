package dev.rusatom.qa.steps.platform.personalOffice;

import dev.rusatom.qa.helper.WebDriverHelper;
import dev.rusatom.qa.page.PlatformPersonalOfficeLoginPage;

import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDefs {
    private WebDriver driver = WebDriverHelper.getDriver();
    private PlatformPersonalOfficeLoginPage loginPage = new PlatformPersonalOfficeLoginPage(driver);

    @Когда("Открываем стартовую страницу личного кабинета")
    public void openStartPage() {
        loginPage.openStartPage();
    }

    @И("Вводим логин {string}")
    public void inputLogin(String login) {
        if ("по-умолчанию".equals(login)) {
            loginPage.inputLogin();
        } else {
            loginPage.inputLogin(login);
        }
    }

    @И("Вводим пароль {string}")
    public void inputPwd(String pwd) {
        if ("по-умолчанию".equals(pwd)) {
            loginPage.inputPasswd();
        } else {
            loginPage.inputPasswd(pwd);
        }
    }

    @Затем("Нажимаем кнопку Войти")
    public void clickLoginButton() {
        loginPage.clickLoginBtn();
    }
}
