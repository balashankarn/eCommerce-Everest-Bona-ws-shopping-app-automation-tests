 @MSHAPP-172 @AccountDashboard
Feature: MSHAPP-172 Account Dashboard: Signed In (basic version)

  Scenario Outline: Verify that user is able to Land into Account page
    Given user launches the apps
    When user clicks sign in option
    And user enter username "<username>" and password "<password>" clicks on login
    Then User should be in homepage
    Then User should be in Account page
    Examples:
      |username|password|
     | bala3@test.com | test@1234 |


  Scenario: Verify that UI as per design in Account setting page
    When user is able should be able to view all the elements on dashboard
    Then user should be able scroll up and down of the screen


  Scenario: Verify whether user is able to click on account setting option
    And user clicks on account setting option
    Then user should be navigated to account setting screen.
    And user quits the screen