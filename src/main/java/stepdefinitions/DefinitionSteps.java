package stepdefinitions;

import asserts.Asserts;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rozetkapages.HomePage;
import rozetkapages.ProductGroupPage;
import rozetkapages.ProductPage;
import utils.Driver;

public class DefinitionSteps {
    private final HomePage homePage = new HomePage(Driver.getDriver());
    private final ProductPage productPage = new ProductPage(Driver.getDriver());
    private final ProductGroupPage productGroupPage = new ProductGroupPage(Driver.getDriver());
    private final Asserts asserts = new Asserts();

    @Before
    public void setUp() {
        Driver.getDriver();
        Driver.getURL();
    }

    @Given("User makes search by keyword {string}")
    public void enterKeyWordToSearchInput(String group) {
        homePage.enterKeyWordToSearchInput(group);
    }

    @And("User enters brand name to brand search input {string}")
    public void enterBrandToBrandSearchInput(String brandName) {
        productGroupPage.enterBrandToBrandSearchInput(brandName);
    }

    @And("User checks brand checkbox {string}")
    public void checkBrandCheckbox(String brandName) {
        productGroupPage.checkBrandCheckbox(brandName);
    }

    @And("User checks ready to ship checkbox")
    public void checkReadyToShipCheckbox() {
        productGroupPage.checkReadyToShipCheckbox();
    }

    @And("User selects sorting type {string}")
    public void selectSortingType(String sortingType) {
        productGroupPage.selectSortingType(sortingType);
    }

    @And("User clicks on first product")
    public void clickOnFirstProduct() {
        productGroupPage.clickOnFirstProduct();
    }

    @When("User clicks on add to cart button")
    public void clickOnAddToCartButton() {
        productPage.clickOnAddToCartButton();
    }

    @Then("User verifies that number of items in cart is {int}")
    public void verifyThatNumberOfItemsInCartIs(int expectedNumberInCart) {
        asserts.verifyThatNumberOfItemsInCartIs(expectedNumberInCart);
    }

    @Then("User verifies that total sum in cart less than {int}")
    public void verifyThatTotalSumInCartLessThan(int maxSum) {
        asserts.verifyThatTotalSumInCartLessThan(maxSum);
    }

    @After
    public void tearDown() {
        Driver.closeBrowser();
    }
}
