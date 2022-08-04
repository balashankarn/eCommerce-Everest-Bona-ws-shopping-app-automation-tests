@MSHAPP-1025
Feature: MSHAPP-1025:Optimized Create Registry -Step 1: First Name Last Name


  Scenario: verify whether user is able to navigate registry dashboard
     Given user launches the apps
     When User continue shopping as guest user
     And Sign out the app if already signed in
     And  user click on registry in bottom navigation bar
     Then  user lands on registry screen

     Scenario: Verify user is navigated to create registry screen
      Given user is on registry screen
      When  user clicks on create registry
      Then user lands on sign in screen

      Scenario Outline: verify whether user is able to login
        Given user is on sign screen
        And user enter username "<username>" and password "<password>" clicks on login in sign in page
        Then user should land on create registry screen one
        And user quits the screen
        Examples:
          | username    | password |
          | bala3@test.com | test@1234 |




      



