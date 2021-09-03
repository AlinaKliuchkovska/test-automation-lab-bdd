package rozetkapages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import rozetkapages.element.Button;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".button_size_large")
    private Button addToCartButton;


    public void clickOnAddToCartButton() {
        waitForElementToBeClickable(addToCartButton);
        addToCartButton.clickWithJSExecutor(driver);
    }
}