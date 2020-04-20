package core;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.Util;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


public class InitAndroid {

    public AndroidDriver<AndroidElement> driver;

    public Util util = new Util();

    public AndroidElement initDriver(AndroidDriver driver, final MobileBy byType){
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        AndroidElement element = (AndroidElement) wait.until(new Function<AndroidDriver, AndroidElement>() {
            public AndroidElement apply(AndroidDriver driver) {
                driver = MobileHelper.getAndroidDriver();
                return (AndroidElement) driver.findElement(byType);
            }
        });
        wait.until(ExpectedConditions.elementToBeClickable(byType));
        return element;
    }

    public AndroidElement initDriverBy(AndroidDriver driver, By byType){
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(90))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);
        AndroidElement element = (AndroidElement) wait.until(new Function<AndroidDriver, AndroidElement>() {
            public AndroidElement apply(AndroidDriver driver) {
                driver = MobileHelper.getAndroidDriver();
                return (AndroidElement) driver.findElement(byType);
            }
        });
        wait.until(ExpectedConditions.elementToBeClickable(byType));
        return element;
    }

}
