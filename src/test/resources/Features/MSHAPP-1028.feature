@MSHAPP-1028
Feature:MSHAPP-1028 Registry Privacy Settings -Tell me about

  Scenario: verify whether user is able to navigate registry dashboard

    Given user launches the apps
    When  user click on registry in bottom navigation bar
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
      | username    | password |
      | bala3@test.com | test@1234 |
  Scenario: verify user is able select privacy setting
    Given user  is on create event screen
    And user clicks on privacy setting and selects privacy
    Then the selected privacy type should be populated