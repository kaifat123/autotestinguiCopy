package dev.rusatom.qa.steps.platform.personalOffice;

import dev.rusatom.qa.helper.DriverHooks;
import dev.rusatom.qa.page.PlatformPersonalOffice;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PersonalOfficeStepDefs {
    private WebDriver driver = DriverHooks.getWebDriver();
    private PlatformPersonalOffice personalOffice = new PlatformPersonalOffice(driver);

    @Тогда("Проверить что заголовок страницы личного кабинета равен {string}")
    public void commonCheckHeadlinePersOff(String string){
        Assert.assertEquals("Заголовок не равен ожидаемому",personalOffice.commonCheckToHeadline(),string);
    }
}
