@MSHAPP-177 @UpdatePassword @Regression
Feature:Account Settings: Password Update

  Scenario Outline: Verify Whether user is able to Login into the App
    Given user launches the apps
    When user clicks sign in option
    And user enter username "<username>" and password "<password>" clicks on login
    Then User should be in homepage
    Then User should be in Account page
    Examples:
      | username       | password  |
      | bala3@test.com | test@1234 |

  Scenario:verify whether user ia able to navigate to account setting screen
    And user clicks on account setting option
    Then user should be navigated to account setting screen.

  Scenario: verify whether user is able to navigate to change password
    When user clicks on change password
    Then user lands on change password


  Scenario Outline: verify whether user is able to enter current password and new password
    When  user clicks on the current password and new password
    Then  user enter "<currentpassword>" and "<newpassword>"
    And user quits the screen
    Examples:
      | currentpassword | newpassword |
      | bala3@test.com  | test@1234   |