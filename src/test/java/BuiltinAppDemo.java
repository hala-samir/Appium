import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BuiltinAppDemo {
    AppiumDriver driver;
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("app",System.getProperty("user.dir")+"/Apps/ApiDemos-debug.apk");
        caps.setCapability("deviceName","HUAWEI Y7 Prime 2018");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity",".Calculator");
        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void clickBtn()
    {
        driver.findElement(By.id("digit_1")).click();
        driver.findElement(By.id("op_add")).click();
        driver.findElement(By.id("digit_2")).click();
        driver.findElement(By.id("eq")).click();
        Assert.assertEquals((driver.findElement(By.id("formula")).getText()),"3");
//        Assert.assertTrue((driver.findElement(By.id("result")).getText()).endsWith("3"));
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
