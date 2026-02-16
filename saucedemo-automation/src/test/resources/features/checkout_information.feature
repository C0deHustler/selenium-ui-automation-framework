Feature: Checkout Information validation on SauceDemo

  @Smoke @CheckoutInfo
  Scenario: TC19 - Valid checkout information
    Given User is on Checkout: Your Information page
    When User enters checkout information "John" "Doe" "12345"
    Then User should be redirected to Checkout Overview page

  @CheckoutInfo
  Scenario: TC20 - Missing First Name
    Given User is on Checkout: Your Information page
    When User enters checkout information "" "Doe" "12345"
    Then Error message "First Name is required" should be displayed

  @CheckoutInfo
  Scenario: TC21 - Missing Last Name
    Given User is on Checkout: Your Information page
    When User enters checkout information "John" "" "12345"
    Then Error message "Last Name is required" should be displayed

  @CheckoutInfo
  Scenario: TC22 - Missing Postal Code
    Given User is on Checkout: Your Information page
    When User enters checkout information "John" "Doe" ""
    Then Error message "Postal Code is required" should be displayed
