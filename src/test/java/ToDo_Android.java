import PageObjects.AddTask;
import PageObjects.TaskListPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.JSONReader;

import java.io.IOException;
import java.net.MalformedURLException;

public class ToDo_Android extends TestBase {
    AddTask addTaskPage;
    TaskListPage taskListPage;
    @DataProvider(name="tasks data")
    public Object[][] passData() throws IOException, ParseException {
        return JSONReader.jsonData(System.getProperty("user.dir")+"/Data/Data.json",
                "TaskData",2);
    }
    @Test(dataProvider = "tasks data")
    public void test_add_task(String taskName, String taskDesc) throws MalformedURLException {
        Android_setup();
        addTaskPage= new AddTask(driver);
        taskListPage= new TaskListPage(driver);
        taskListPage.clickAddTask();
        addTaskPage.enterTaskTitle(taskName);
        addTaskPage.enterNotes(taskDesc);
        //addTaskPage.enterTag("e2e");
        addTaskPage.clickSaveBtn();
        tearDown();
    }
}
