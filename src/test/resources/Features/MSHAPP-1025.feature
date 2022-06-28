Feature: Create Registry

  Scenario: verify whether user is able to navigate create registry step -1

    Given user launches the apps
    When  user click on registry in bottom navigation bar
    Then  user lands on registry screen

    Scenario: Verify user is navigated to sign in screen
    Given user is on registry screen
    When  user clicks on create registry
     Then user lands on sign in screen




    Scenario: Verify whether user is on able to login into my account
      Given user is in sgin screen
      When user enter username {string} and password {string} clicks on login
      



