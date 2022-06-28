@updatepassword
Feature:Account Settings: Password Update

  Scenario Outline: Verify Whether user is able to Login into the App
    Given user launches apps and clicks on account setting button
    When user clicks sign in option
    And user enter username "<username>" and password "<password>" clicks on login
    Then user lands on dashboard screen
    Examples:
      | username    | password |
      | bala3@test.com | test@1234 |

  Scenario:
