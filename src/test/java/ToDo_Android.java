import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ToDo_Android extends TestBase {
    AddTask addTaskPage;
    TaskListPage taskListPage;
    @Test
    public void test_add_task() throws MalformedURLException {
        Android_setup();
        addTaskPage= new AddTask(driver);
        taskListPage= new TaskListPage(driver);
        taskListPage.clickAddTask();
        addTaskPage.enterTaskTitle("Automation Task");
        addTaskPage.enterNotes("Appium for Mobile");
        //addTaskPage.enterTag("e2e");
        addTaskPage.clickSaveBtn();
        tearDown();
    }
}
