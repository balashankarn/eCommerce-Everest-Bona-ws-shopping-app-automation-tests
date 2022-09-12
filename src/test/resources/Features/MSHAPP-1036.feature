@MSHAPP-1036 @Regression
Feature: Optimized Create Registry - Step 4: Confirmation

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
  Examples:
   | username       | password  |
   | bala3@test.com | test@1234 |

 Scenario: Verify that User is able to fill up all the required fields of 1st screen of Create Registry flow nad move to 2nd screen
  And user select the event type as "Baby"
  And user clicks on event type and selects event date
  And user select the Privacy setting as "Public"
  And user clicks on Next button

 Scenario Outline: Verify that User is able to fill up all the required fields of the 2nd screen of Create Registry flow and move to 3rd screen
  And user enter "<Address>" and "<City>" and "<State>" and "<Zip>" and "<Phone>"
  And user clicks on Next button

  Examples:
   | Address           | City       | State   | Zip   | Phone      |
   | 801 Tom Martin Dr | Birmingham | Alabama | 35211 | 9163487549 |

 Scenario:Verify that user is able to land on the 3rd screen of Create Registry flow
  Then user should be in the third screen

  Scenario:Verify that user is able to navigate to confirmation screen after creating Registry
   And User click on Create Registry Button
   Then User should able to see the message "Congratulations, you’re registered!" in  confirmation screen
   And user quits the screen

