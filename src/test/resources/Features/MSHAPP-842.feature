@MSHAPP-842
Feature: CapitalOne Terms & Conditions link

  Scenario Outline: Verify Whether user is able to Login into the App
    Given user launches the apps
    When user clicks sign in option
    And user enter username "<username>" and password "<password>" clicks on login
    Then user lands on dashboard screen
    Examples:
      | username       | password  |
      | bala3@test.com | test@1234 |

  Scenario: verify whether user is able too view items on cart
    Given user is account dashboard screen
    When user clicks on cart option in tab bar
    Then once user is cart screen user should be able to view checkout button

  Scenario: verify whether user is able to click on checkout
    Given user is in checkout screen
    When user click checkout  in payment screen
    Then user should see capital one link

  Scenario: User verifies the Capital one link first functionality
    Given user is in capital one link and verify whether it is a sheet
    When user pinches or spread to zoom the pdf
    Then user clicks cancel on top right

  Scenario: User verifies the Capital one link second functionality
    Given user is in capital one link and verify whether it is a sheet
    When user pinches or spread to zoom the pdf
    Then user swipes down to close the sheet
