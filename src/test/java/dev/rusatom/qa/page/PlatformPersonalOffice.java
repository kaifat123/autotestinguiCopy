package dev.rusatom.qa.page;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PlatformPersonalOffice {
    private static Logger logger = LogManager.getLogger(PlatformPersonalOfficeLoginPage.class);
    public WebDriver driver;

    public PlatformPersonalOffice(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * локатор заголовка страницы личного кабинета
     */
    @FindBy(xpath = "//div[@class='layout__body']//h3")
    private WebElement commonHeadline;

    /**
     * локатор меню навигации личного кабинета
     */
    @FindBy(xpath = "//div[contains(@class,'header-drop__inner dropdown')]//button[@id='dropdownUserButton']")
    private WebElement buttonDropDownNavigation;

    /**
     * локатор меню сервиса личного кабинета
     */
    @FindBy(xpath = "//div[contains(@class,'header-user-drop__inner dropdown')]//button[@id='dropdownUserButton']")
    private WebElement buttonDropDownServices;

    /**
     * локатор списка навигационных элементов
     */
    @FindAll({@FindBy(xpath = "//div[contains(@class,'dropdown-content dropdown-menu header-drop__menu show')]/a/span")})
    private List<WebElement> listDropDownNavigation;

    /**
     * локатор списка сервисных элементов
     */
    @FindAll({@FindBy(xpath = "//div[@class='user-drop-section']//div[contains(@class,'cabinet-service-item') and not(contains(@style,'display:none'))]/a")})
    private List<WebElement> listDropDownServices;

    /**
     * локатор ФИ пользователя указанного в выпадающем меню сервисов личного кабинета
     */
    @FindBy(xpath = "//button[@id='dropdownUserButton']/div[contains(@class,'header-user-drop__title')]")
    private WebElement namesUserDropDownServices;

    /**
     * локатор закладки Личный кабинет
     */
    @FindBy(xpath = "//a[@class='header-menu__item header-menu__item_active']")
    private WebElement bookmarkActivePagePersonalOffice;

    /**
     * локатор баннера Госуслуги
     */
    @FindBy(xpath = "//div[@id='footer']//a[@href='https://www.gosuslugi.ru/']")
    private WebElement bannerGosuslugi;

    /**
     * локатор подвала
     */
    @FindBy(xpath = "//div[@class='footer__container']")
    private WebElement commonFooter;

    /**
     * Метод получения текста заголовка страницы личного кабинета
     */
    public String commonCheckToHeadline() {
        logger.info("Возвращаем заголовок страницы личного кабинета");
        return commonHeadline.getText();
    }

    /**
     * Метод проверки наличия меню навигации на странице личного кабинета
     */
    public boolean checkVisibleButtonDropDownNavigation() {
        logger.info("Проверка отображения меню навигации на странице личного кабинета");
        return buttonDropDownNavigation.isDisplayed();
    }

    /**
     * Метод нажатия на меню навигации на странице личного кабинета
     */
    public void clickButtonDropDownNavigation() {
        logger.info("Нажатие на выпадающее меню навигации на странице личного кабинета");
        buttonDropDownNavigation.click();
    }

    /**
     * Метод проверки наличия меню сервиса на странице личного кабинета
     */
    public boolean checkVisibleButtonDropDownServices() {
        logger.info("Проверка отображения меню сервисов на странице личного кабинета");
        return buttonDropDownServices.isDisplayed();
    }

    /**
     * Метод нажатия на меню сервиса на странице личного кабинета
     */
    public void clickButtonDropDownServices() {
        logger.info("Нажатие на выпадающее меню сервисов на странице личного кабинета");
        buttonDropDownServices.click();
    }

    /**
     * Метод получения списка меню навигации выпадающего списка на странице личного кабинета
     */
    public List getListButtonDropDownNavigation() {
        logger.info("Получение списка элементов выпадающего меню навигации на странице личного кабинета");
        List<String> elementList = new ArrayList<>();
        List<WebElement> list = listDropDownNavigation;
        for (WebElement element : list) {
            elementList.add(element.getText());
        }
        return elementList;
    }

    /**
     * Метод получения списка меню сервисов выпадающего списка на странице личного кабинета
     */
    public List getListButtonDropDownServices() {
        logger.info("Получение списка элементов выпадающего меню сервисов на странице личного кабинета");
        List<String> elementList = new ArrayList<>();
        List<WebElement> list = listDropDownServices;
        for (WebElement element : list) {
            elementList.add(element.getText());
        }
        return elementList;
    }

    /**
     * Метод получения ФИ авторизованного пользователя в выпадающем меню сервисов личного кабинета
     */
    public String getNamesUserDropDownServices() {
        logger.info("Получение ФИ авторизованного пользователя в выпадающем меню сервисов личного кабинета");
        return namesUserDropDownServices.getText();
    }

    /**
     * Метод получения названия объекта активной закладки личного кабинета
     */
    public String getBookmarkActivePagePersonalOffice() {
        logger.info("Возвращаем название активной закладки личного кабинета");
        return bookmarkActivePagePersonalOffice.getText();
    }

    /**
     * Метод получения объекта баннера Госуслуги
     */
    public WebElement getBannerGosuslugi() {
        logger.info("Возвращаем объект баннера Госуслуги");
        return bannerGosuslugi;
    }

    /**
     * Метод получения текста в подвале в зависимости от заголовка
     */
    public String getCommonFooter(String title) {
        String text = commonFooter.findElement
                (By.xpath(String.format("//div[@class='footer__block-header' and text()='%s']/following-sibling::*//*[contains(@class,'footer__block-link')]", title)))
                .getText();
        Allure.addAttachment("Значение элемента на странице", text);
        logger.info("Возвращаем значение в подвальном разделе " + title);
        return text;
    }
}
