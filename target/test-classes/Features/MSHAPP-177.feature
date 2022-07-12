#@updatepassword
#Feature:Account Settings: Password Update
#
#  Scenario Outline: Verify Whether user is able to Login into the App
#    Given user launches apps and clicks on account setting button
#    When user clicks sign in option
#    And user enter username "<username>" and password "<password>" clicks on login
#    Then user lands on dashboard screen
#    Examples:
#      | username    | password |
#      | bala3@test.com | test@1234 |
#
#  Scenario:verify whether user ia able to navigate to account setting screen
#    Given user is in account dashboard
#    When  user launches apps and clicks on account setting
#    Then  user is in accoount setting screen
#
#  Scenario: verify whether user is able to navigate to change password
#    Given user lands on account setting page
#    When user clicks on change password
#    Then user lands on change password
#
#  Scenario Outline: verify whether user is able to enter current password and new password.
#    Given user is in change password screen
#    When  user clicks on the current password and new password
#    Then  user enter "<currentpassword>" and "<newpassword>"
#    Examples:
#      | currentpassword       | newpassword  |
#      | bala3@test.com | test@1234 |