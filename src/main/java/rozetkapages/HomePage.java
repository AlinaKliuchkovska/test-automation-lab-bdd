package rozetkapages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import rozetkapages.element.TextInput;
import utils.Driver;

import static org.openqa.selenium.Keys.ENTER;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "search")
    private TextInput searchInput;

    public void enterKeyWordToSearchInput(String keyWord) {
        waitForVisibilityOfElement(searchInput);
        for(int i = 0; i < 2; i++) {
            try{
                searchInput.sendKeys(keyWord, ENTER);
                break;
            }catch (StaleElementReferenceException e){
                System.err.println(e.getMessage());
            }
        }
    }
}