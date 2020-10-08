package dev.rusatom.qa.helper;

import dev.rusatom.qa.factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WebDriverHelper {
    private static Logger logger = LogManager.getLogger(WebDriverHelper.class);
    private static WebDriver driver;

    public static WebDriver getDriver() {
            String browser = ConfProperties.getProperty("driver.browser.name");
            browser = browser.toLowerCase();
            driver = WebDriverFactory.create(browser);
        ChromeOptions options = new ChromeOptions();

options.addArguments("--headless");
        driver = new ChromeDriver(options);
            logger.info("Драйвер " + browser + " поднят");
        return driver;
    }

    public static WebDriver getDriver(String value) {
            driver = WebDriverFactory.create(value.toLowerCase());
            logger.info("Драйвер " + value + " поднят");
        return driver;
    }
}
