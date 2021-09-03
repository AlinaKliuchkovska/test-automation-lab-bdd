package rozetkapages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import rozetkapages.element.Product;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;


public class CartPopup extends BasePage {
    public CartPopup(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']")
    private WebElement totalSum;

    @FindBy(xpath = "//div[contains(@class,'modal__holder')]")
    private WebElement cartPopup;

    @FindBy(css = ".cart-list__item")
    private List<Product> productsInCartList;

    public int getNumberOfProductsInCart() {
        for(int i = 0; i < 3; i++) {
            try{
                waitForVisibilityOfElement(cartPopup);
                waitForVisibilityOfElement(productsInCartList.get(0));
                break;
            }catch (StaleElementReferenceException e){
                System.err.println(e.getMessage());
            }
        }
        return productsInCartList.size();
    }

    public int getTotalSum() {
        return Integer.parseInt(totalSum.getText().replaceAll("[^0-9]+", ""));
    }
}