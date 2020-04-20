package Actions;

import Pages.CheckoutPage;
import utils.TV;

import static org.junit.Assert.assertTrue;

public class CheckoutActions extends CheckoutPage {

    public void assertTVDetails(TV tv) {
        assertTrue(checkOutName().getText().contains(tv.getName()));
        assertTrue(checkOutPrice().getText().contains(tv.getPrice()));
    }
}
