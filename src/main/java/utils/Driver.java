package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    private static final PropertiesReader propertiesReader = new PropertiesReader();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty(propertiesReader.getDriverName(), propertiesReader.getDriverLocation());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void getURL() {
        getDriver().get(propertiesReader.getURL());
    }

    public static void closeBrowser() {
        driver.close();
        driver.quit();
        driver = null;
    }
}