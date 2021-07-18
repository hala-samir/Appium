import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SMS {
    AndroidDriver driver;
    AndroidTouchAction action;
   // private static By message= By.id("swipeableContent");

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("app",System.getProperty("user.dir")+"/Apps/ApiDemos-debug.apk");
        caps.setCapability("deviceName","emulator-5554");
        caps.setCapability("appPackage","com.google.android.apps.messaging");
        caps.setCapability("appActivity",".ui.conversationlist.ConversationListActivity");
        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test(priority = 0)
    public void send_sms()
    {
        driver.sendSMS("00201234567834", "Hello World");
    }

    @Test(priority = 1)
    public void delete_sms()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        TouchAction touchAction = new TouchAction(driver);

        WebElement message=  driver.findElement(By.id("conversation_name"));
        WebElement toolbar=  driver.findElement(By.id("toolbar"));

        touchAction.longPress(ElementOption.element(message)).waitAction().release().perform();
        touchAction.moveTo(ElementOption.element(toolbar)).waitAction().perform();
        AndroidElement deleteBtn= (AndroidElement)driver.findElement(By.id("action_delete"));
        Actions actionxx = new Actions(driver);
        actionxx.moveToElement(deleteBtn).click().perform();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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
