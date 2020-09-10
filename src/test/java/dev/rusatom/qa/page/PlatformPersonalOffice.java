package dev.rusatom.qa.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlatformPersonalOffice {
    private static Logger logger = LogManager.getLogger(PlatformPersonalOfficeLoginPage.class);
    public WebDriver driver;

    public PlatformPersonalOffice(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='layout__body']//h3")
    private WebElement commonHeadline;

    public String commonCheckToHeadline(){
        logger.info("Возвращаем заголовок страницы личного кабинета");
        return commonHeadline.getText();
    }
}
