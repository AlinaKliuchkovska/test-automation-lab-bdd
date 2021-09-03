package rozetkapages.element;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends Element {
    public Button(WebElement element) {
        super(element);
    }

    public void clickWithJSExecutor(WebDriver driver) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
    }
}