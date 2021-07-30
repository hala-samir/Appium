Feature: Create New Task

  Scenario Outline:The user can add a new task
    Given Click Add new Task
    Given Enter "<TaskName>" and "<TaskDesc>"
    When Click Save
    Then Task added successfully
    Examples:
      | TaskName | TaskDesc |
      | CucumberTask1 | Task1Details1   |
      | CucumberTask2 | TaskDetails2    |