@Regression
Feature: Manage Registry || Primary registry

  Scenario: verify that user is able to navigate registry dashboard
    Given user launches the apps
    When User continue shopping as guest user
    When Sign out the app if already signed in
    When  user click on registry in bottom navigation bar
    Then  user lands on registry screen

  Scenario: Verify that user is navigated to create registry screen
    Given user is on registry screen
    When  user clicks on create registry
    Then user lands on sign in screen

  Scenario Outline: verify that user is able to login
    Given user is on sign screen
    And user enter username "<username>" and password "<password>" clicks on login in sign in page
    Then user should land on create registry screen one
    And User navigate to backPage
    Examples:
      | username| password|
      | kiruba6@test.com | test@1234|

    Scenario: Verify that user is able to see SHARE icon is actives
      When user user clicks on MANAGE YOUR REGISTRIES
      Then User should able to see the SHARE icon is active of the Registry "AutoTest"

      Scenario:Verify that user is able to see default sharing options
      When click on SHARE icon of the Registry "AutoTest"
        Then User should able to see default sharing options
        And user quits the screen


