package Pages;

import core.AndroidLocator;
import io.appium.java_client.android.AndroidElement;
import utils.ObjectReader;

import java.util.List;

public class TvInfoPage extends AndroidLocator {

    private ObjectReader page;

    public TvInfoPage(){
        page = new ObjectReader("support/pageElements/tvInfoPage.yml");
    }

    protected AndroidElement tvName() {return getLocator(page, "name");}

    protected AndroidElement price() {return getLocator(page, "price");}

    protected AndroidElement description() {return getLocator(page, "description");}

    protected List<AndroidElement> isDescription() {return getLocatorList(page, "description");}

    protected List<AndroidElement> isAddToCart() {return getLocatorList(page, "addToCart");}

    protected AndroidElement addToCart() {return getLocator(page, "addToCart");}

    protected AndroidElement checkOut() {return getLocator(page, "checkOut");}
}
