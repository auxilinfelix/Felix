Feature: User want to add the New Employee Training records

  #Background:
  #Given Launch the Browser

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
|index | empid | empname | coursename | Trainername | Trainingtype | startDate | endDate   | status      | percentagecompletion |
#| 0    | A1345 | Felix   | Selenium   | Harish      | 0        | 09/24/2025| 09/24/2025|   0 | 100                  |
| 1    | H1143 | Jerry   | Playwright | Naveen      | 1     | 09242025| 09242025| 0 | 50                   |
#| 2    | M7769 | Clinton | TestCafe   | Kishore     | 2    | 09/24/2025| 09/24/2025| 2 | 70                   |
#| 3    | R2679 | Cyril   | CyPress    | Vinoth      | 3      | 09/24/2025| 09/24/2025|   3 | 90                   |
