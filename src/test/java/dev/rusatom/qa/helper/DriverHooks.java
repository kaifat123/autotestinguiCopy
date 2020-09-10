package dev.rusatom.qa.helper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DriverHooks {
    private static WebDriver driver;
    protected static WebDriverWait wait;
    public static Logger logger = LogManager.getLogger(DriverHooks.class);

    @Before
    public static void setUp() {

        String browser = System.getProperty("browser");
        if (browser == null) {
            driver = WebDriverHelper.getDriver();
        } else {
            driver = WebDriverHelper.getDriver(browser);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);


    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    @After
    public static void setDown() {
        driver.quit();
        logger.info("Закрытие браузера");
    }
}
