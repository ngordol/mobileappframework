package Tests;


import core.MobileHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;


public class TestSetup extends MobileHelper
{

    @Before
    public void setup() {
        ANDROID_DRIVER = launchAndroid();
    }

    @After
    public void tearDown(){
        quitAndroidDriver();
        System.out.println("Test Complete");
    }
}
