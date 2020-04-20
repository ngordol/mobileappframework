package Pages;

import core.AndroidLocator;
import io.appium.java_client.android.AndroidElement;
import utils.ObjectReader;

public class CheckoutPage extends AndroidLocator {

    private ObjectReader page;

    public CheckoutPage(){
        page = new ObjectReader("support/pageElements/checkoutPage.yml");
    }

    protected AndroidElement checkOutName() { return getLocator(page, "checkOutName");}

    protected AndroidElement checkOutPrice() {return getLocator(page, "checkOutPrice");}

}
