package Actions;

import Pages.AmazonPage;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AmazonActions extends AmazonPage {

    public void searchForTv(String tv) {
        searchBar().click();
        search().click();
        search().sendKeys(tv);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickTV(){

        while(isTvVisible().isEmpty()) {
            scrollDown();
        }
        tv().click();
    }


}
