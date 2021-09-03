package asserts;

import rozetkapages.CartPopup;
import utils.Driver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Asserts {
    private final CartPopup cartPopup = new CartPopup(Driver.getDriver());

    public void verifyThatNumberOfItemsInCartIs(int expectedNumberOfItemsInCart){
        assertEquals(expectedNumberOfItemsInCart, cartPopup.getNumberOfProductsInCart());
    }

    public void verifyThatTotalSumInCartLessThan(int maxSum){
        assertTrue(cartPopup.getTotalSum() < maxSum);
    }
}
