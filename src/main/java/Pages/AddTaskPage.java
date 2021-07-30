package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddTaskPage extends PageBase {

    public AddTaskPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
   // MobileElement rateLater;

    @AndroidFindBy(id = "editTextTitre")
    MobileElement taskTitle;

    @AndroidFindBy(id = "editTextNote")
    MobileElement noteText;

    @AndroidFindBy(id = "editTextTag")
    MobileElement tag;

    @AndroidFindBy(id = "action_save")
    MobileElement saveBtn;

    public void enterTaskTitle(String title) {
        fillTxtField(taskTitle,title);

    }

    public void enterNotes(String notes) {

        fillTxtField(noteText, notes);
    }

    public void clickSaveBtn(){

        clickBtn(saveBtn);
    }


}
