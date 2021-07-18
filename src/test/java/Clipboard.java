import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Clipboard {
    AndroidDriver driver;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("app",System.getProperty("user.dir")+"/Apps/selendroid-test-app.apk");
        caps.setCapability("deviceName","AndroidEmulator");
        driver= new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), caps);

    }

    @Test
    public void clipboard()  {
        AndroidElement txtField=(AndroidElement) driver.findElementByAccessibilityId("my_text_fieldCD");
        String text= "Welcome to Appium Automation";
        driver.setClipboardText(text);
        txtField.clear();
        txtField.sendKeys(driver.getClipboardText());
        Assert.assertEquals(text,txtField.getText());
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
