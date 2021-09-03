package rozetkapages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import rozetkapages.element.CustomFieldDecorator;


public abstract class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    public static final long TIME_TO_WAIT = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIME_TO_WAIT);
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void waitForVisibilityOfElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitForElementToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}