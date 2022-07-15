@MSHAPP-1032
Feature:-Optimized Create Registry - Step 3: Co-Registrant

  Scenario Outline: verify whether user is able to navigate registry dashboard
    Given user launches the apps for the first time
    When user select to sign in
    And user enter username "<username>" and password "<password>" clicks on login in sign in page
#    And user cliks on continue shopping
    Then user clicks on continue shopping
    Examples:
      | username       | password  |
      | bala3@test.com | test@1234 |

  Scenario: Verify user is navigated to create registry screen
    Given user navigates to registry screen
#    When  user click on registry in bottom navigation bar
    When user scrolls to the bottom of the page
    Then  user clicks on create registry in the bottom of the screen
#    Then user lands on sign in screen
#
#Scenario Outline: verify whether user is able to login
#Given user is on sign screen
#And user enter username "<username>" and password "<password>" clicks on login in sign in page
#Then user should land on create registry screen one
#Examples:
#| username    | password |
#| bala3@test.com | test@1234 |

  Scenario: verify user is able navigate to next screen
    Given user  is on create event screen
    And user clicks on privacy setting and selects privacy
    And user clicks on event type and selects event
    Then user clicks on next step

  Scenario: verify user is able navigate to next screen
    Given user is step three screen
    And user clicks on next button
    Then user lands on step three screen