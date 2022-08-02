@editemail
Feature: MSHAPP-176 Account Settings: Edit email: Form only; no text entry or submission yet

  Scenario Outline: Verify that user is able to Login into the App
    Given user launches apps and clicks on account setting button
    When user clicks sign in option
   And user enter username "<username>" and password "<password>" clicks on login
    Then User should be in homepage
    Then User should be in Account page
    Examples:
      |username|password|
      | bala3@test.com | test@1234 |

  Scenario: Verify that user is able to click on email edit option
    And user clicks on account setting option
    Then user should be navigated to account setting screen.
    And user click on edit email option

  Scenario: Verify that UI is as per the sketch
    Then user should be navigated to edit email screen
    Given user is in edit email screen
    Then UI should be as per the sketch
    Then user should  be able to tap on both fields

  Scenario Outline: Verify whether user close without saving data
    When user enter currentpassword "<currentpassword>" and newemailaddress "<newemailaddress>" clicks on close
    Then user should be navigated back to account setting screen

    Examples:
    | currentpassword  | |newemailaddress|
    |    bala@123   |    |   bala3@test.com|