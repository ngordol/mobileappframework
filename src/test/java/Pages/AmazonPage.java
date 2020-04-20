package Pages;

import core.AndroidLocator;
import io.appium.java_client.android.AndroidElement;
import utils.ObjectReader;

import java.util.List;

public class AmazonPage extends AndroidLocator {
        private ObjectReader page;

    public AmazonPage(){ page = new ObjectReader("support/pageElements/homePage.yml"); }

    protected AndroidElement searchBar(){ return getLocator(page, "searchBar"); }

    protected AndroidElement search(){ return getLocator(page, "search");}

    protected AndroidElement tv(){ return getLocator(page, "randomTV");}

    protected List<AndroidElement> isTvVisible(){return getLocatorList(page, "randomTV");}


}
