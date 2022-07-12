#Feature: checkout-I can sign in to my account or choose to checkout as a guest before I enter the checkout funnel
#
#  @checkout
#  Scenario:Verify whether user is click on cart without sign in
#
#    Given user launches apps
#    And user clicks on cart
#    Then user lands on checkout
#
#    @checkout
#    Scenario: Verify whether user is able to click on checkout
#
#      Given user is on the checkout page
#      And user clicks on checkout button
#      Then user should land on login page
#
#    @checkout
#    Scenario: verify whether user is able to navigate back to cart page
#      Given user is on login page
#      And user clicks on cross button
#      Then user should land on cart page
