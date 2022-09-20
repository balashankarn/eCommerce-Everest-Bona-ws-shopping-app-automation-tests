@MSHAPP-1032 @Regression
Feature:-Optimized Create Registry - Step 3: Co-Registrant

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
    And user select the event type as "Birth"
    And user clicks on event type and selects event date
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


#  Scenario: Verify that co-registrant checkbox is not selected as default
#    Then user should able to see co-registrant checkbox is not selected as default


  Scenario Outline: Verify that user is able see the mandatory fields and enter minimum 1 character
    And  click on checkbox for co-registrant
    Then user should able to see First name and Last name
    Then User should able to enter in "<FirstName>" and "<LastName>" with minimum 1 character

    Examples:
      | FirstName | LastName |
      | c         | c        |

  Scenario: Verify that User is able to see co-registrant form fields should gets hidden after uncheck
    And uncheck the co-registrant checkbox
    Then User should able to see co-registrant form gets hidden

  Scenario: Verify that co-registrant checkbox is not selected as default to access this registry
    And click on checkbox for co-registrant
    Then user should able to see co-registrant checkbox is not selected as default to access this registry

  Scenario: Verify that user is able to see the mandatory fields when click on co-registrant checkbox to access the registry
    And user click on checkbox for access this registry
    Then user should able to see the fields "Email" and "Confirm Email" and "NAME YOUR REGISTRY" when the form fields open


  Scenario Outline:Verify that User is able to enter the email Id in valid format
    Then User should able to enter "<Email>" and "<Confirm Email>"

    Examples:
      | Email                  | Confirm Email          |
      | autotest1234@gmail.com | autotest1234@gmail.com |

  Scenario: Verify that User is able to see email fields gets hidden after uncheck
    Then User should able to see email fields gets hidden after uncheck
    And user quits the screen




























