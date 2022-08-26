@MSHAPP-1033 @Regression

Feature:Optimized Create Registry - Step 3: Personalize Registry creation

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

  Scenario Outline: Verify that User is able to fill up all the required fields of the 2nd screen of Create Registry flow nad move to 3rd screen
    And user enter "<Address>" and "<City>" and "<State>" and "<Zip>" and "<Phone>"
    And user clicks on Next button

    Examples:
      | Address           | City       | State   | Zip   | Phone      |
      | 801 Tom Martin Dr | Birmingham | Alabama | 35211 | 9163487549 |


  Scenario:Verify that user is able to land on the 3rd screen of Create Registry flow
    Then user should be in the third screen

  Scenario Outline:Verify that user is able to enter a name with maximum of 40 character in NAME YOUR REGISTRY  field
    Then User should able to enter a name "<NAME YOUR REGISTRY>" with maximum of 40 character

    Examples:
      | NAME YOUR REGISTRY                       |
      | The Name of your Registry Auto   Testing |

  Scenario Outline: Verify that user is able to  enter special character in NAME YOUR REGISTRY field
    Then User should able to enter special character "<NAME YOUR REGISTRY>"

    Examples:
      | NAME YOUR REGISTRY   |
      | AutoTesting!@$5^&&** |

  Scenario:  Verify that user is able to see the label I want to add a message to my guests
    Then User should able to see label "I want to add a message to my guests"

  Scenario Outline: Verify that user is able to enter a maximum of 300 characters in the message field
    Then User should able to enter a maximum of 300 characters "<Message>" in the message field
    Then User should able to see the character count as "0/300" after entering the below Message

    Examples:
      | Message                                                                                                                                                                                                                                                                                                      |
      | it is for the testing it is for the testing it is for the testing it is for the testing it is for the testing it is for the testing it is for the testing it is for the testing it is for the testing it is for the testing it is for the testing it is for the testing it is for the testing it is for test |

  Scenario: Verify that user is able to see the checkbox to add message to guests gets checked
    Then User should able to see the checkbox to add message to guests gets checked

  Scenario:Verify thar user is able to see the Enter the guest message field should be hidden after uncheck
    And click on checkbox for add a message to my guests
    Then User should able to see the Enter the guest message field should be hidden
    And user quits the screen








