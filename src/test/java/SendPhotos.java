import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class SendPhotos {
    AndroidDriver driver;
    private static By backupBtn= By.id("auto_backup_switch");
    private static By touch_outside= By.id("touch_outside");
    private static By backupOffBtn= By.id("android:id/button2");
    private static By photo= By.xpath("//android.view.ViewGroup[contains(@content-desc,'Photo taken')]");
    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("app",System.getProperty("user.dir")+"/Apps/ApiDemos-debug.apk");
        caps.setCapability("deviceName","AndroidEmulator");
        caps.setCapability("appPackage", "com.google.android.apps.photos");
        caps.setCapability("appActivity",".home.HomeActivity");

        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    @Test
    public void sendPhoto() throws IOException {
        File classPath,imagDir,img;
        classPath= new File(System.getProperty("user.dir"));
        imagDir = new File(classPath, "/resources");
        img = new File(imagDir.getCanonicalFile(), "ben-sweet-2LowviVHZ-E-unsplash-1.jpeg");

        WebDriverWait  wait= new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(backupBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(touch_outside)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(backupOffBtn)).click();
        String AndroidPhotoPath= "mnt/sdcard/Pictures";
        String s=AndroidPhotoPath+"/"+img.getName();

        driver.pushFile(s,img);
        ExpectedCondition condition=ExpectedConditions.numberOfElementsToBe(photo,1);
        wait.until(condition);
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
