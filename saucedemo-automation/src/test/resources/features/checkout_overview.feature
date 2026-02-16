Feature: Checkout Overview validation on SauceDemo

  @Smoke @CheckoutOverview 
  Scenario: TC23 - Verify order summary
    Given User is on Checkout: Overview page with products added
    Then Selected products and quantities should be displayed

  @CheckoutOverview
  Scenario: TC24 - Verify total amount calculation
    Given User is on Checkout: Overview page with products added
    Then Item total, tax, and total amount should be displayed correctly

  @CheckoutOverview
  Scenario: TC25 - Finish checkout
    Given User is on Checkout: Overview page with products added
    When User confirms the order
    Then User should be redirected to Checkout: Complete page

  @CheckoutOverview
  Scenario: TC26 - Cancel checkout
    Given User is on Checkout: Overview page with products added
    When User clicks Cancel button
    Then User should be redirected to Products page
