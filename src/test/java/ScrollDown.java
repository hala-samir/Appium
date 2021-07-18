import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;


public class ScrollDown {
    AppiumDriver driver;
    AndroidTouchAction action;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("app",System.getProperty("user.dir")+"/Apps/ApiDemos-debug.apk");
        caps.setCapability("deviceName","AndroidEmulator");

        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void tap_test()
    {
        AndroidElement views= (AndroidElement)driver.findElementByAccessibilityId("Views");
        action= new AndroidTouchAction(driver);
        action.tap(ElementOption.element(views)).perform();

        //AndroidElement fullList=(AndroidElement)driver.findElement(By.id("android:id/content"));
        MobileElement list=(MobileElement)driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView("
                                +"new UiSelector().description(\"Lists\"));"));
        System.out.println(list.getLocation());

        list.click();
        AndroidElement lists=  (AndroidElement) driver.findElementByAccessibilityId("Lists");
        action.tap(ElementOption.element(lists)).waitAction().perform();
    }

    @AfterTest
    public void tearDown()
    {
        if(null!=driver)
        {
            driver.quit();
        }
    }
}
