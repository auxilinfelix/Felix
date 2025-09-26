
Feature: User want to add the New Employee Training records

  #Background:
  #Given Launch the Browser

@regression 
  Scenario Outline: Validation of creating the new user in Employee Training records
    Given User launch the Employee Training url "http://10.192.190.130:3000/"
    When User clicks on Add Training button
    And Verify user navigated to the Add Training page
    And Select the project name "<index>"
    And User enter the Employee Id "<empid>"
    And User enter the Employee name "<empname>"
    And User enter the  Course name "<coursename>"
    And User enter the Trainer name "<Trainername>"
    And User select the Training type "<Trainingtype>"
    And User enter the start date "<startDate>"
    And User enter the end date "<endDate>"
    And User select the Status "<status>"
    And User enter the completion percentage "<percentagecompletion>"
    And User clicks on Add button
    Then User navigated to the Training Summary page
Examples:
|index | empid | empname | coursename | Trainername | Trainingtype | startDate | endDate   | status       | percentagecompletion |
#| 0    | A1345 | Felix   | Selenium   | Harish      | 0            | 09242025  | 09242025  | 1           | 100                  |
| 1    | H1143 | Jerry   | Playwright | Naveen      | 2            | 09242025  | 09242025  | 1            | 50                   |

@sanity
 Scenario Outline: Validation of creating the new user with Empty Employee name
    Given User launch the Employee Training url "http://10.192.190.130:3000/"
    When User clicks on Add Training button
    And Verify user navigated to the Add Training page
    And Select the project name "<index>"
    And User enter the Employee Id "<empid>"
   # And User enter the Employee name "<empname>"
    And User enter the  Course name "<coursename>"
    And User enter the Trainer name "<Trainername>"
    And User select the Training type "<Trainingtype>"
    And User enter the start date "<startDate>"
    And User enter the end date "<endDate>"
    And User select the Status "<status>"
    And User enter the completion percentage "<percentagecompletion>"
    And User clicks on Add button
    #And User can see the error message for empty Employee name "<Errormsg>"
    Then User navigated to the Training Summary page

Examples:
|index | empid | empname | coursename | Trainername | Trainingtype | startDate | endDate   | status      | percentagecompletion | Errormsg                |
| 2    | M7769 | Joseph  | TestCafe   | Kishore     | 2            | 09242025  | 09242025  | 2           | 70                   | Uncaught runtime errors:|


@smoke
 Scenario Outline: Validation of creating the new user with Empty Trainer name
    Given User launch the Employee Training url "http://10.192.190.130:3000/"
    When User clicks on Add Training button
    And Verify user navigated to the Add Training page
    And Select the project name "<index>"
    And User enter the Employee Id "<empid>"
    And User enter the Employee name "<empname>"
    And User enter the  Course name "<coursename>"
   # And User enter the Trainer name "<Trainername>"
    And User select the Training type "<Trainingtype>"
    And User enter the start date "<startDate>"
    And User enter the end date "<endDate>"
    And User select the Status "<status>"
    And User enter the completion percentage "<percentagecompletion>"
    And User clicks on Add button without Trainer name
    And User enter the Trainer name "<Trainername>"
    And User clicks on Add button
    Then User navigated to the Training Summary page

Examples:
|index | empid | empname | coursename | Trainername | Trainingtype | startDate | endDate   | status      | percentagecompletion |
| 2    | M7769 | Clinton | TestCafe   | Kishore     | 2            | 09242025  | 09242025  | 2           | 70                   |


@Editing
 Scenario: Edit the Employee Traning records in the React Page
 Given User launch the Employee Training url "http://10.192.190.130:3000/"
# When User clicks on Add Training button
 Then Verify user is on training records projectName, EmployeeName
 Then click edit on first record
 And verify user is on edit training
 Then I change the employeename to "Jerry" and the course to "Automation"
 Then click on update button


@Deleting
 Scenario: Search employeename and course delete first record
 Given User launch the Employee Training url "http://10.192.190.130:3000/"
 When user click on training summary
 Then verify user is on training records projectName, EmployeeName
 Then search for employeename "Felix"
 Then search for course "Auto"
 Then click delete on frist record