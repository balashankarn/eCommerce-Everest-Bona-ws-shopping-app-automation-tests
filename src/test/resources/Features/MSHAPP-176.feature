#@editemail
#Feature: MSHAPP-176 Account Settings: Edit email: Form only; no text entry or submission yet
#
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
#  Scenario: Verify whether user is able to click on email edit option
#    Given user is on account dashboard screen
#    When user navigate to account setting page
#    And user click on edit email option
#    Then user should be navigated to edit email screen
#
#  Scenario: Verify whether UI is as per the sketch
#    Given user is in edit email screen
#    When user should  be able to tap on both feilds
#    Then UI should be as per the sketch
#
#  Scenario Outline: Verify whether user close without saving data
#    Given user is in edit email screen
#    When user enter currentpassword "<currentpassword>" and newemailaddress "<newemailaddress>" clicks on close
#    Then user should be navigated back to account setting screen
#
#    Examples:
#    | currentpassword  | |newemailaddress|
#    |    bala@123   |    |   bala3@test.com|