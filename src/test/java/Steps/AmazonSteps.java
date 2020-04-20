package Steps;

import Actions.AmazonActions;
import Actions.CheckoutActions;
import Actions.LoginActions;
import Actions.TvInfoActions;
import net.thucydides.core.annotations.Step;
import utils.TV;

public class AmazonSteps {

    private AmazonActions amazonActions;
    private LoginActions loginActions;
    private TvInfoActions tvInfoActions;
    private CheckoutActions checkoutActions;

    public AmazonSteps(){

        amazonActions = new AmazonActions();
        loginActions = new LoginActions();
        tvInfoActions = new TvInfoActions();
        checkoutActions = new CheckoutActions();

    }

    public void clickLogin() {
        loginActions.clickLogin();
    }

    public void searchForTv(String TV) {
        amazonActions.searchForTv(TV);
        amazonActions.clickTV();
    }

    public TV getProductDetails(){
        return tvInfoActions.saveTvInfoAndAddtoCart();
    }

    public void clickCheckout(){
        tvInfoActions.clickCheckout();
    }

    public void verifyCheckoutDetails(TV tv){
        checkoutActions.assertTVDetails(tv);
    }
}
