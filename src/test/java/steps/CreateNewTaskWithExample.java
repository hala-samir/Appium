package steps;

import Pages.AddTaskPage;
import Pages.TaskListPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTaskWithExample extends TestBase {
    AddTaskPage createTaskPage;
    TaskListPage taskListPage;
    private String taskName;
    private String taskDesc;

    @Given("Click Add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setup();
        createTaskPage= new AddTaskPage(driver);
        taskListPage= new TaskListPage(driver);
        //createTaskPage.clickRateLater();
        taskListPage.clickAddTask();
    }

    //@Given("Enter {string} and {string}")
    @Given("Enter \"(.*)\" and \"(.*)\"")
    public void enterAnd(String taskName,String taskDesc) {
        createTaskPage.enterTaskTitle(taskName);
        createTaskPage.enterNotes(taskDesc);
    }

    @When("Click Save")
    public void clickSave() {
        createTaskPage.clickSaveBtn();
    }

    @Then("Task added successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        tearDown();
    }


}
