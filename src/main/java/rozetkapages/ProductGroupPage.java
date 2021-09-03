package rozetkapages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import rozetkapages.element.*;
import utils.Driver;

import java.util.NoSuchElementException;

import static org.openqa.selenium.Keys.ENTER;


public class ProductGroupPage extends BasePage {
    public ProductGroupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//select[contains(@class, 'ng-star-inserted')]")
    private CustomSelect sortingTypeSelect;

    @FindBy(xpath = "//a[contains(@href,'gotovo-k-otpravke')]/ancestor::li")
    private CheckBox readyToShipCheckbox;

    @FindBy(xpath = "//button[@class='button button_type_link sidebar-alphabet__toggle']//preceding::input[@class='sidebar-search__input ng-untouched ng-pristine ng-valid']")
    private TextInput brandSearchInput;

    @FindBy(css = ".goods-tile__heading")
    private Button firstProduct;

    public ProductGroupPage enterBrandToBrandSearchInput(String brandName) {
        for(int i = 0; i < 3; i++) {
            try{
                brandSearchInput.sendKeys(brandName, ENTER);
                break;
            }catch (StaleElementReferenceException e){
                System.err.println(e.getMessage());
            }
        }
        return this;
    }

    public ProductGroupPage selectSortingType(String sortingType) {
        waitForElementToBeClickable(sortingTypeSelect);
        sortingTypeSelect.selectByVisibleText(sortingType);
        return this;
    }

    public ProductGroupPage clickOnFirstProduct() {
        waitForElementToBeClickable(firstProduct);
        firstProduct.clickWithJSExecutor(driver);
        return this;
    }

    public ProductGroupPage checkReadyToShipCheckbox() {
        try {
            waitForElementToBeClickable(readyToShipCheckbox);
            for(int i = 0; i < 2; i++){
                try{
                    readyToShipCheckbox.setChecked(true);
                    break;
                }catch (StaleElementReferenceException e){
                    System.err.println(e.getMessage());
                }
            }
        } catch (NoSuchElementException | TimeoutException e) {
            System.out.println("Checkbox is not enabled");
        }
        return this;
    }

    public ProductGroupPage checkBrandCheckbox(String brandName){
        waitForElementToBeClickable(driver.findElement(By.xpath(String.format("//input[@id='%s']//parent::a", brandName))));
        for(int i = 0; i < 2; i++) {
            try{
                driver.findElement(By.xpath(String.format("//input[@id='%s']//parent::a", brandName))).click();
                break;
            }catch (StaleElementReferenceException e){
                System.err.println(e.getMessage());
            }
        }
        return this;
    }
}