package dev.rusatom.qa.steps.platform.personalOffice;

import dev.rusatom.qa.helper.DriverHooks;
import dev.rusatom.qa.page.PlatformPersonalOffice;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonalOfficeStepDefs {
    private WebDriver driver = DriverHooks.getWebDriver();
    private PlatformPersonalOffice personalOffice = new PlatformPersonalOffice(driver);

    @Тогда("Проверить что заголовок страницы личного кабинета равен {string}")
    public void commonCheckHeadlinePersOff(String string) {
        assertEquals("Заголовок не равен ожидаемому", string, personalOffice.commonCheckToHeadline());
    }

    @Тогда("Получить список выпадающего меню {string} личного кабинета и сравнить с таблицей:")
    public void checkListDropDownMenu(String nameMenu, DataTable data) {
        switch (nameMenu) {
            case "навигации":
                assertEquals("Ошибка при сравнении списка объектов", data.asList(), personalOffice.getListButtonDropDownNavigation());
                break;
            case "сервисов":
                assertEquals("Ошибка при сравнении списка объектов", data.asList(), personalOffice.getListButtonDropDownServices());
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + nameMenu);
        }
    }

    @Тогда("Проверить, что отображаемое ФИ пользователя в выпадающем списке сервисов равно {string}")
    public void checkNamesUserDropDownServices(String names) {
        assertEquals("Значение Фимилия-Имя авторизованного пользователя не равно ожидаемому", names, personalOffice.getNamesUserDropDownServices());
    }

    @Тогда("{string} баннер/баннера Госуслуги в личном кабинете")
    public void commonBannerGosuslugi(String action) {
        switch (action) {
            case "Проверить наличие":
                assertTrue(personalOffice.getBannerGosuslugi().isDisplayed());
                break;
            case "Нажать на":
                personalOffice.getBannerGosuslugi().click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    @Тогда("Проверить, что название активной закладки личного кабинета равно {string}")
    public void checkBookmarkActivePagePersonalOffice(String bookmark) {
        assertEquals("Название активной закладки не равно ожидаемому значению", bookmark, personalOffice.getBookmarkActivePagePersonalOffice());
    }

    @Тогда("{string} выпадающее/выпадающего меню {string} личного кабинета")
    public void commonCheckDropDownMenu(String action, String nameMenu) {
        switch (action) {
            case "Проверить наличие":
                switch (nameMenu) {
                    case "навигации":
                        assertTrue(personalOffice.checkVisibleButtonDropDownNavigation());
                        break;
                    case "сервисов":
                        assertTrue(personalOffice.checkVisibleButtonDropDownServices());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + nameMenu);
                }
                break;
            case "Нажать на":
                switch (nameMenu) {
                    case "навигации":
                        personalOffice.clickButtonDropDownNavigation();
                        break;
                    case "сервисов":
                        personalOffice.clickButtonDropDownServices();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + nameMenu);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + action);
        }
    }

    @Step
    @Тогда("Сравнить значение текста в нижней части страницы, разделе {string} с текстом {string}")
    public void checkTextFooter(String title, String text) {
        assertEquals("Текст не равен ожидаемому значению", text, personalOffice.getCommonFooter(title));
    }
}
