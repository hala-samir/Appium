import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class HybridApp {
    static AppiumDriver driver;
    private static By chromeBtn= MobileBy.AccessibilityId("buttonStartWebviewCD");
    private static By toHomeBtn= By.id("goBack");
    private static By webSection= By.id("mainWebView");

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("platformVersion", "8.1");
        caps.setCapability("app",System.getProperty("user.dir")+"/Apps/selendroid-test-app.apk");
        caps.setCapability("deviceName","AndroidEmulator");
        caps.setCapability("noReset", true);
        caps.setCapability("autoGrandPermissions", "true");
        driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    public void switchContext() {
        Set<String> contexts = driver.getContextHandles();
        System.out.println(contexts);
        for (String context : contexts) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
               // System.out.println(context+"Swiched");
                break;
            }
        }
    }
    @Test
    public void hybridTest()
    {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(chromeBtn)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(webSection));
        switchContext();
        System.out.println("after switch()"+driver.getContext());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement txtField = driver.findElement(By.id("name_input"));
        txtField.clear();
        txtField.sendKeys("This is my name");
        driver.context("NATIVE_APP");
        System.out.println("after returning to main contxt"+driver.getContext());
        wait.until(ExpectedConditions.presenceOfElementLocated(toHomeBtn)).click();
        driver.findElement(toHomeBtn).click();
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
