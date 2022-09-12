@MSHAPP-1043 @Regression
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
      | username       | password  |
      | kiruba6@test.com | test@1234 |

  Scenario: Verify that user is able to see the following section Should be editable
    When user user clicks on MANAGE YOUR REGISTRIES
    And click on Edit button of the Registry "AutoTest"

    Scenario: Verify that Tell us about your special day section editable
    Then user should able to edit the Tell us about your special day section

  Scenario: Verify that WHEN IS THE EVENT section editable
    Then user should able to edit the WHEN IS THE EVENT section


  Scenario: Verify that Tell us about your special day section editable
    Then user should able to edit the Tell us about your special day section


  Scenario: Verify that Tell us about your special day section editable
    Then user should able to edit the Tell us about your special day section

  Scenario: Verify that SHIPPING ADDRESS editable
    Then user should able to edit the SHIPPING ADDRESS section

  Scenario: Verify that CO-REGISTRANT INFORMATION  section editable
    Then user should able to edit the CO-REGISTRANT INFORMATION  section

  Scenario: Verify that POTTERY BARN KIDS section editable
    Then user should able to edit the POTTERY BARN KIDS section

  Scenario: Verify that WHAT ARE YOUR REGISTRY PREFERENCES section editable
    Then user should able to edit the WHAT ARE YOUR REGISTRY PREFERENCES section
    And user quits the screen




