import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class Swipe {

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
    public void swipe()
    {
        action= new AndroidTouchAction(driver);
        AndroidElement views= (AndroidElement)driver.findElementByAccessibilityId("Views");

        action.tap(ElementOption.element(views)).perform();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        AndroidElement gallery= (AndroidElement)driver.findElementByAccessibilityId("Gallery");
        action.tap(ElementOption.element(gallery)).perform();

        AndroidElement photos= (AndroidElement) driver.findElementByAccessibilityId("1. Photos");
        action.tap(ElementOption.element(photos)).perform();

        AndroidElement pic1= (AndroidElement) driver.findElements(By.className("android.widget.ImageView")).get(0);
        action.press(ElementOption.element(pic1)).waitAction().moveTo(PointOption.point(-500,40)).release().perform();


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
