package core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.ObjectReader;

import java.util.List;
import java.util.Set;

public class AndroidLocator extends InitAndroid {

    /**
     * Waits and locates the elements by strategy.
     *
     * @return Android Element
     * @throws IllegalArgumentException
     */

    public AndroidElement getLocator(ObjectReader page, String key) {
        this.driver = MobileHelper.getAndroidDriver();
        String strategy = page.getKey(key+".type");
        String element = page.getKey(key+".element");
        AndroidElement e = null;
        switch (strategy) {
            case ("id"):
                e= initDriver(this.driver, new MobileBy.ByAndroidUIAutomator
                        ("new UiSelector().resourceId(\"\"com.amazon.mShop.android.shopping/"+element+"\")"));
                break;
            case ("chromeID"):
                e= initDriver(this.driver, new MobileBy.ByAndroidUIAutomator
                        ("new UiSelector().resourceId(\""+element+"\")"));
                break;
            case ("xpath"):
                e= initDriverBy(this.driver, By.xpath(element));
                break;
            case ("text"):
                e= initDriver(this.driver, new MobileBy.ByAndroidUIAutomator
                        ("text(\""+element+"\")"));
                break;
            default:
                throw new IllegalArgumentException("Not supported");
        }
        return e;
    }

    public List<AndroidElement> getLocatorList(ObjectReader page, String key){
        this.driver = MobileHelper.getAndroidDriver();
        String strategy = page.getKey(key+".type");
        String element = page.getKey(key+".element");
        List<AndroidElement> e = null;
        try {
            switch (strategy) {
                case ("id"):
                    e = this.driver.findElementsByAndroidUIAutomator
                            ("new UiSelector().resourceId(\"com.amazon.mShop.android.shopping/" + element + "\")");
                    break;
                case ("xpath"):
                    e = this.driver.findElements(By.xpath(element));
                    break;
                case ("text"):
                    e = this.driver.
                            findElementsByAndroidUIAutomator("text(\"" + element + "\")");
                    break;
                case ("chromeID"):
                    e= this.driver.findElementsByAndroidUIAutomator
                            ("new UiSelector().resourceId(\""+element+"\")");
                    break;
                default:
                    throw new IllegalArgumentException("Not supported");
            }
        }catch(NoSuchElementException exception){
            exception.printStackTrace();
        }
        return e;

    }

    public String returnPageSource(){
        this.driver = MobileHelper.getAndroidDriver();
        return this.driver.getPageSource();
    }

    /**
     * This method scrolls to the element using touch action
     * Just a static scroll down used to find in conjunction with while loop
     *
     * @return void
     */
    public void scrollDown() {
        this.driver = MobileHelper.getAndroidDriver();
        int heightStart = this.driver.manage().window().getSize().getHeight();
        int heightEnd = this.driver.manage().window().getSize().getHeight() ;
        int centerPoint = this.driver.manage().window().getSize().getWidth()/2;

        heightStart = (int) (heightEnd * .80);
        heightEnd = (int) (heightEnd * .40);

        TouchAction myAction = new TouchAction(MobileHelper.getAndroidDriver());
        myAction.press(PointOption.point(
                centerPoint,
                heightStart))
                .moveTo(PointOption.point(
                        centerPoint,
                        heightEnd)
                ).waitAction().release().perform();
    }



}
