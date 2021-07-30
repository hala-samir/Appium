/*
package steps;

import Pages.AddTaskPage;
import Pages.TaskListPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTask extends TestBase {
   AddTaskPage createTaskPage;
   TaskListPage taskListPage;

    @Given("Click Add New Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setup();
        createTaskPage= new AddTaskPage(driver);
        taskListPage= new TaskListPage(driver);
        createTaskPage.clickRateLater();
        taskListPage.clickAddTask();
        throw new io.cucumber.java.PendingException();
    }

    @Given("Enter Task Name")
    public void enterTaskName() {
        createTaskPage.enterTaskTitle("cucumber");
        throw new io.cucumber.java.PendingException();
    }

    @Given("Enter Task Description")
    public void enterTaskDescription() {
        createTaskPage.enterNotes("behaviour driven");
        throw new io.cucumber.java.PendingException();

    }

    @When("Click Add button")
    public void clickAddButton() {
        createTaskPage.clickSaveBtn();
        throw new io.cucumber.java.PendingException();
    }

    @Then("Task Added Successfully")
    public void taskAddedSuccessfully() {
        driver.hideKeyboard();
        tearDown();
        throw new io.cucumber.java.PendingException();
    }
}
*/
package steps;


import Pages.AddTaskPage;
import Pages.TaskListPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tests.TestBase;

import java.net.MalformedURLException;

public class CreateNewTask extends TestBase {
    AddTaskPage createTaskPage;
    TaskListPage taskListPage;

    @Given("Click Add new Task")
    public void clickAddNewTask() throws MalformedURLException {
        Android_setup();
        createTaskPage= new AddTaskPage(driver);
        taskListPage= new TaskListPage(driver);
        taskListPage.clickAddTask();
    }

    @Given("Enter TaskName")
    public void enterTaskName() {
        createTaskPage.enterTaskTitle("Task 1");
    }

    @Given("Enter TaskDesc")
    public void enterTaskDesc() {
        createTaskPage.enterNotes("Desc 1");
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
