import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddTask extends PageBase {

    public AddTask(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }
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

    public void enterTag(String tagname){

        fillTxtField(tag, tagname);
    }

    public void clickSaveBtn(){
        clickBtn(saveBtn);
    }

}
