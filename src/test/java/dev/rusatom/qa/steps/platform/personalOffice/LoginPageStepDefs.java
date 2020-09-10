package dev.rusatom.qa.steps.platform.personalOffice;

import dev.rusatom.qa.helper.DriverHooks;
import dev.rusatom.qa.page.PlatformPersonalOfficeLoginPage;
import io.cucumber.java.ru.Затем;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Flaky;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class LoginPageStepDefs {
    private WebDriver driver = DriverHooks.getWebDriver();
    private PlatformPersonalOfficeLoginPage loginPage = new PlatformPersonalOfficeLoginPage(driver);
    private static final Logger logger = LogManager.getLogger(LoginPageStepDefs.class);

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

    @Затем("Проверить, что поле ввода {string} отображается")
    public void commonCheckField(String field) {
        switch (field) {
            case "Электронная почта / Логин":
                Assert.assertTrue("Поле \"Электронная почта / Логин\" не отображается", loginPage.getObjectLogin().isDisplayed());
                break;
            case "Имя":
                Assert.assertTrue("Поле \"Имя\" не отображается", loginPage.getFirstNameField().isDisplayed());
                break;
            case "Фамилия":
                Assert.assertTrue("Поле \"Фамилия\" не отображается", loginPage.getLastNameField().isDisplayed());
                break;
            case "Отчество":
                Assert.assertTrue("Поле \"Отчество\" не отображается", loginPage.getMiddleNameField().isDisplayed());
                break;
            case "Email":
                Assert.assertTrue("Поле \"Email\" не отображается", loginPage.getEmailField().isDisplayed());
                break;
            case "Пароль":
                Assert.assertTrue("Поле \"Пароль\" не отображается", loginPage.getPasswdField().isDisplayed());
                break;
            case "Подтверждение Пароля":
                Assert.assertTrue("Поле \"Подтверждение Пароля\" не отображается", loginPage.getPasswordConfirmField().isDisplayed());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + field);
        }
    }

    @Затем("Нажимаем кнопку Войти")
    public void clickLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Когда("Пройдена авторизация")
    public void authByDefault() {
        loginPage.openStartPage();
        loginPage.inputLogin();
        loginPage.inputPasswd();
        loginPage.clickLoginBtn();
    }

    @Тогда("Проверить, что title страницы равен {string}")
    public void checkTitle(String string) {
        Assert.assertEquals("Title страницы отличается от ожидаемого", driver.getTitle(), string);
    }

    @Тогда("Проверить, что заголовок страницы авторизации равен {string}")
    public void checkHeadline(String string) {
        Assert.assertEquals("Заголовок страницы авторизации отличается от ожидаемого", loginPage.getHeadline(), string);
    }

    @Тогда("Проверить, что наименование поля логин равен {string}")
    public void checkNameLogin(String string) {
        Assert.assertEquals("Наименование поля логин отличается от ожидаемого", loginPage.getNameLoginSpace(), string);
    }

    @Тогда("Проверить, что наименование поля пароль равен {string}")
    public void checkNamePwd(String string) {
        Assert.assertEquals("Наименование поля пароль отличается от ожидаемого", loginPage.getNamePwdSpace(), string);
    }

    //Ловит значения "Проверить наличие" и "Нажать"
    @Тогда("{string} чек-бокс/чек-бокса \"Запомнить\"")
    public void checkOrClickCheckboxRemember(String string) {
        switch (string) {
            case "Проверить наличие":
                Assert.assertTrue("Ошибка отображения чек-бокса \"Запомнить\"", loginPage.getCheckboxRemember().isDisplayed());
                break;
            case "Нажать":
                loginPage.getCheckboxRemember().click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + string);
        }
    }

    /**
     * Parameter1 :
     * Ловит значения "Проверить наличие" и "Нажать"
     * <p>
     * Parameter2 :
     * Ловит значения "Забыли пароль?" и Регистрация"
     */
    @Тогда("{string} ссылки/ссылку {string}")
    public void checkOrClickResetPwdAndRegistrations(String action, String link) {
        switch (action) {
            case "Проверить наличие":
                switch (link) {
                    case "Забыли пароль?":
                        Assert.assertTrue("Ошибка отображения ссылки для сброса пароля", loginPage.getLinkResetPwd().isDisplayed());
                        break;
                    case "Регистрация":
                        Assert.assertTrue("Ошибка отображения ссылки для сброса пароля", loginPage.getLinkRegistration().isDisplayed());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + link);
                }
                break;
            case "Нажать":
                switch (link) {
                    case "Забыли пароль?":
                        loginPage.getLinkResetPwd().click();
                        break;
                    case "Регистрация":
                        loginPage.getLinkRegistration().click();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + link);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    /**
     * Parameter1 :
     * Ловит значения "Проверить наличие" и "Нажать"
     * <p>
     * Parameter2 :
     * Ожидает название социальной сети для авторизации
     */

    @Flaky
    @Тогда("{string} кнопки/кнопку для авторизации через соц.сеть {string}")
    public void checkOrClickSocialButton(String action, String socialNet) {
        switch (action) {
            case "Проверить наличие":
                switch (socialNet) {
                    case "ЕСИА":
                        Assert.assertTrue("Кнопка ЕСИА не отображается", loginPage.getBtnESIA().isDisplayed());
                        break;
                    case "Apple":
                        Assert.assertTrue("Кнопка Apple не отображается", loginPage.getBtnAppleID().isDisplayed());
                        break;
                    case "VK":
                        Assert.assertTrue("Кнопка VK не отображается", loginPage.getBtnVkID().isDisplayed());
                        break;
                    case "Yandex":
                        Assert.assertTrue("Кнопка Yandex не отображается", loginPage.getBtnYandexID().isDisplayed());
                        break;
                    case "Mail.ru":
                        Assert.assertTrue("Кнопка Mail.ru не отображается", loginPage.getBtnMailID().isDisplayed());
                        break;
                    case "OK":
                        Assert.assertTrue("Кнопка OK не отображается", loginPage.getBtnOkID().isDisplayed());
                        break;
                    case "Facebook":
                        Assert.assertTrue("Кнопка Facebook не отображается", loginPage.getBtnFacebookID().isDisplayed());
                        break;
                    case "Google":
                        Assert.assertTrue("Кнопка Google не отображается", loginPage.getBtnGoogleID().isDisplayed());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + socialNet);
                }
                break;
            case "Нажать":
                switch (socialNet) {
                    case "ЕСИА":
                        loginPage.getBtnESIA().click();
                        break;
                    case "Apple":
                        loginPage.getBtnAppleID().click();
                        break;
                    case "VK":
                        loginPage.getBtnVkID().click();
                        break;
                    case "Yandex":
                        loginPage.getBtnYandexID().click();
                        break;
                    case "Mail.ru":
                        loginPage.getBtnMailID().click();
                        break;
                    case "OK":
                        loginPage.getBtnOkID().click();
                        break;
                    case "Facebook":
                        loginPage.getBtnFacebookID().click();
                        break;
                    case "Google":
                        loginPage.getBtnGoogleID().click();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + socialNet);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    /**
     * Parameter1 :
     * Ловит значения "Проверить наличие" или "Нажать"
     * <p>
     * * Parameter2 :
     * * Ловит значения "Назад", "Подтвердить", "Регистрация"
     */
    @Тогда("{string} кнопку/кнопки {string}")
    public void checkOrClickBtnBack(String action, String btn) {
        switch (action) {
            case "Проверить наличие":
                switch (btn) {
                    case "Назад":
                        Assert.assertTrue("Кнопка \"Назад\" не отображается", loginPage.getBtnBack().isDisplayed());
                        break;
                    case "Подтвердить":
                        Assert.assertTrue("Кнопка \"Подтвердить\" не отображается", loginPage.getBtnSubmit().isDisplayed());
                        break;
                    case "Регистрация":
                        Assert.assertTrue("Кнопка \"Регистрация\" не отображается", loginPage.getBtnRegistration().isDisplayed());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + btn);
                }
                break;
            case "Нажать":
                switch (btn) {
                    case "Назад":
                        loginPage.getBtnBack().click();
                        break;
                    case "Подтвердить":
                        loginPage.getBtnSubmit().click();
                        break;
                    case "Регистрация":
                        loginPage.getBtnRegistration().click();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + btn);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    @Тогда("Проверить, что отображается ссылка на условия соглашения на странице регистрации")
    public void checkLinkTermOfUse() throws Exception {
        Assert.assertEquals("Текст ссылки на соглашение отличается от ожидаемого",loginPage.getTermsOfUse().getText(),"Условиями использования");
        loginPage.getTermsOfUse().click();
        Thread.sleep(4000);
        saveAllureScreenshot();
    }

    @Тогда("Проверить, что текст информационного поля на форме сброса пароля равен {string}")
    public void checkInfoWrapperDownResetPwd(String value) {
        String text = loginPage.getInfoWrapperDownResetPwd().getText();
        Allure.attachment("Значение поля", text);
        Assert.assertEquals("Текст отличается от ожидаемого", value, text);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot()
    { return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); }
}


