@orderHistory
Feature: Order history

  Scenario Outline: Verify Whether user is able to Login into the App
    Given user launches apps and clicks on account setting button
    When user clicks sign in option
    And user enter username "<username>" and password "<password>" clicks on login
    Then user lands on dashboard screen
    Examples:
      | username    | password |
      | bala3@test.com | test@1234 |


  Scenario: Verify Whether user can go to Order history from Left nav in My account Section
    Given user is in home page
    When user clicks on account tab
    And user clicks on order history link in my account page
    Then user checks whether he is order page or not

