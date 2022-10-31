@MSHAPP-1035 @Regression
Feature: Optimized Create Registry - Step 3: Edit prefilled info

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
    When user enter username "<username>" and password "<password>" clicks on login in sign in page
    Then user should land on create registry screen one
    And User navigate to backPage
    And delete the existing Registry if it available already
    When user clicks on create registry
    Then user should land on create registry screen one
    Examples:
      | username       | password  |
      | bala3@test.com | test@1234 |

  Scenario: Verify that User is able to fill up all the required fields of 1st screen of Create Registry flow nad move to 2nd screen
    And user select the event type as "Birth"
    And user clicks on event type and selects event date
    Then the selected event date should be populated here
    And user select the Privacy setting as "Public"
     And user clicks on Next button

  Scenario Outline: Verify that User is able to fill up all the required fields of the 2nd screen of Create Registry flow nad move to 3rd screen
    And user enter "<Address>" and "<City>" and "<State>" and "<Zip>" and "<Phone>"
    And user clicks on Next button

    Examples:
      | Address           | City       | State   | Zip   | Phone      |
      | 801 Tom Martin Dr | Birmingham | Alabama | 35211 | 9163487549 |

  Scenario:Verify that user is able to land on the 3rd screen of Create Registry flow
    Then user should be in the third screen

    Scenario Outline:  Verify that user is able to see Step 1 information in step 3 screen
      Then User should able to see the Step one information "<First Name and Last Name>","<Event Type>","<Event Date>" in Step three screen

      Examples:
      |First Name and Last Name|Event Type|Event Date|
      |balaNambiar              |Birth     |         - |


  Scenario: Verify that user is able to see the information Before & After Event in readable view
    Then User should able to see the information "Before & After Event" in readable view

  Scenario Outline: Verify that user is able to edit in Step 2 Screen information after clicking on Edit Button of Before & After Event
    When User click on Edit Button
    Then User should Navigate to the second screen
    Then User should able to Edit "<LastName>" in Second Screen information and move to third screen
    Then user should be in the third screen
    And user quits the screen

    Examples:
      | LastName |
      | AutoTest |










