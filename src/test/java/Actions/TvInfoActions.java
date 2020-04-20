package Actions;

import Pages.TvInfoPage;
import utils.TV;

public class TvInfoActions extends TvInfoPage {

    public TV saveTvInfoAndAddtoCart() {
        String tvName = tvName().getText();
        String tvPrice = price().getText();
        clickAddtoCart();
        return new TV(tvName, tvPrice);
    }

    public void clickCheckout() {
       checkOut().click();
    }

    public void clickAddtoCart() {
        while(isAddToCart().isEmpty()) {
            scrollDown();
        }
        addToCart().click();
    }
}
