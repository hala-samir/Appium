package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {
    public  static AppiumDriver driver;
    @BeforeTest
    public void Android_setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.0.0");
        caps.setCapability("deviceName","HUAWEI Y7 Prime 2018");
        //caps.setCapability("deviceName","AndroidEmulator");
        caps.setCapability("appPackage","com.jeffprod.todo");
        caps.setCapability("appActivity",".ActivityMain");
        caps.setCapability("app",System.getProperty("user.dir")+"/APKS/ToDo_v1.24_apkpure.com.apk");
        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
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
