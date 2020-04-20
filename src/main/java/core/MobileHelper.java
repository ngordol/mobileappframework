package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileHelper {

    public static AndroidDriver<AndroidElement> ANDROID_DRIVER = null;
    public static Wait wait = null;
    private static String port = "4723";

    public static AndroidDriver<AndroidElement> launchAndroid() {
        AndroidDriver<AndroidElement> AndroidDriver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        capabilities.setCapability("noSign", "true");

        try {
            AndroidDriver = new AndroidDriver<>(new URL("http://localhost:"+port+"/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return AndroidDriver;
    }

    public static void setAndroidDriver(AndroidDriver <AndroidElement> androidDriver) {
        ANDROID_DRIVER = androidDriver;
    }

    public static AndroidDriver<AndroidElement> getAndroidDriver() {

        wait = new FluentWait(ANDROID_DRIVER)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);

        return ANDROID_DRIVER;
    }

    public static void quitAndroidDriver() {
        ANDROID_DRIVER.quit();
    }


}
