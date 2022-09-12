@MSHAPP-1395
Feature: Manage Registry || Delete

  Scenario Outline: Verify that user is able to Login into the App
    Given user launches the apps
    When user clicks sign in option
    And user enter username "<username>" and password "<password>" clicks on login
    Then User should be in homepage
    When  user click on registry in bottom navigation bar
    And delete the existing Registry if it available already
    Examples:
      | username       | password  |
      | kiruba6@test.com | test@1234 |


