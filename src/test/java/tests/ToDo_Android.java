package tests;

import Pages.AddTaskPage;
import Pages.TaskListPage;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ToDo_Android extends TestBase {
    AddTaskPage addTaskPage;
    TaskListPage taskListPage;
    @Test
    public void test_add_task() throws MalformedURLException {
        Android_setup();
        addTaskPage= new AddTaskPage(driver);
        taskListPage= new TaskListPage(driver);
        taskListPage.clickAddTask();
        addTaskPage.enterTaskTitle("Automation Task");
        addTaskPage.enterNotes("Appium for Mobile");
        addTaskPage.clickSaveBtn();
        tearDown();
    }
}
