package Tests;

import Steps.AmazonSteps;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import net.thucydides.core.annotations.WithTags;
import utils.TV;

@WithTags(
        {
                @WithTag("E2E"),
                @WithTag("Join"),
                @WithTag("loyalty")
        }
)
public class LoginToAmazonAndBuyTVStory extends TestSetup {


    AmazonSteps amazonSteps = new AmazonSteps();

    @Test
    public void verifyLoginAndBuyTVStory() {


        amazonSteps.clickLogin();
        amazonSteps.searchForTv("65 TV");
        TV tv = amazonSteps.getProductDetails();
        amazonSteps.clickCheckout();
        amazonSteps.verifyCheckoutDetails(tv);
    }
}
