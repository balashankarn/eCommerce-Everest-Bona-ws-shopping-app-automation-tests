@MSHAPP-1026 @Regression
Feature:1026-Optimized Create Registry -Step 1: Event Type

  Scenario: verify whether user is able to navigate registry dashboard
    Given user launches the apps
    When User continue shopping as guest user
    And Sign out the app if already signed in
    And  user click on registry in bottom navigation bar
    Then  user lands on registry screen

  Scenario: Verify user is navigated to create registry screen
    Given user is on registry screen
    When  user clicks on create registry
    Then user lands on sign in screen

  Scenario Outline: verify whether user is able to login
    Given user is on sign screen
    And user enter username "<username>" and password "<password>" clicks on login in sign in page
    Then user should land on create registry screen one
    Examples:
      | username       | password  |
      | bala3@test.com | test@1234 |

  Scenario: verify whether user is able to select event type
    Given user  is on create event screen
    And user select the event type as "Baby"
    Then user should able to see the selected value "Baby" in event type
    And user quits the screen

