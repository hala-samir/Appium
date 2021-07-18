import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DragDrop {
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
        driver= new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), caps);
        //---------------------

        /*DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("app",System.getProperty("user.dir")+"/Apps/ApiDemos-debug.apk");
        caps.setCapability("deviceName","HUAWEI Y7 Prime 2018");
        caps.setCapability("appPackage","io.appium.android.apis");
        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);*/
    }

    @Test
    public void dragDrop()  {
        AndroidElement views= (AndroidElement)driver.findElementByAccessibilityId("Views");
        action= new AndroidTouchAction(driver);
        action.tap(ElementOption.element(views)).perform();
        AndroidElement dragDrop= (AndroidElement) driver.findElementByAccessibilityId("Drag and Drop");
        action.tap(ElementOption.element(dragDrop)).waitAction().perform();

        AndroidElement dragPoint= (AndroidElement)driver.findElement(By.id("drag_dot_1"));
        AndroidElement dropPoint= (AndroidElement)driver.findElement(By.id("drag_dot_2"));
        action.longPress(ElementOption.element(dragPoint))
                .waitAction().moveTo(ElementOption.element(dropPoint)).release().perform();
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
