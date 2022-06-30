#@accountdashboard
Feature: MSHAPP-172 Account Dashboard: Signed In (basic version)


  @accountdashboard
  Scenario Outline: Verify Whether user is able to Login into the App
    Given user launches apps and clicks on account setting button
    When user clicks sign in option
    And user enter username "<username>" and password "<password>" clicks on login
    Then user lands on dashboard screen
    Examples:
      | username    | password |
      | bala3@test.com | test@1234 |

  @accountdashbboard
  Scenario: Verify Whether UI as per design
    Given user is dashboard screen
    When user is able should be able to view all the elements on dashboard
    Then user should be able scroll up and down of the screen

  @accountdashboard
  Scenario: Verify whether user is able to click on account setting option
    Given user is on the account dashboard screen
    When user scrolls to bottom of the screen
    And user clicks on account setting option
    Then user should be navigated to account setting screen.