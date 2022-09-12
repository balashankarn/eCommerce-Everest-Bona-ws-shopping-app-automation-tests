@Signin @Regression
Feature: Sign In

  Scenario Outline: Verify that user is able to Sign In with valid username and valid password
      Given user launches the apps
      When  user clicks sign in option
      And user enter username "<valid username>" and password "<valid password>" clicks on login
      Then user lands on dashboard screen
      Examples:
        | valid username    | valid password |
        | bala3@test.com | test@1234 |

    Scenario Outline: Verify that user is not able to Sign In with valid username and invalid password
      Given user launches the apps
      When  user clicks sign in option
      And user enter username "<valid username>" and password "<invalid password>"
      And user click on Login Button
      Then user should not able to navigate to next page

      Examples:
        | valid username    | invalid password|
        | bala3@test.com | test |

  Scenario Outline: Verify that user is not able to Sign In with invalid username and invalid password
    Given user launches the apps
    When  user clicks sign in option
    And user enter username "<invalid username>" and password "<invalid password>"
    And user click on Login Button
    Then user should not able to navigate to next page

    Examples:
      | invalid username    | invalid password|
      | bala3@test | test |


  Scenario Outline: Verify that user is not able to Sign In with valid username and empty password
    Given user launches the apps
    When  user clicks sign in option
    And user enter username "<valid username>" and password "<empty password>"
    And user click on Login Button
    Then user should not able to navigate to next page

    Examples:
      | valid username    | empty password|
      | bala3@test.com | |

  Scenario: Verify that user is not able to Sign In with empty username and empty password
    Given user launches the apps
    When  user clicks sign in option
    And user click on Login Button
    Then user should not able to navigate to next page
    And user quits the screen







