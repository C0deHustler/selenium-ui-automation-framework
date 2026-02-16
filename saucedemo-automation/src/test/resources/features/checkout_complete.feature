Feature: Checkout Completion validation on SauceDemo

  @Smoke @CheckoutComplete
  Scenario: TC27 - Verify order confirmation
    Given User has completed checkout
    Then User should see success message "Thank you for your order!"

  @CheckoutComplete
  Scenario: TC28 - Verify back home button
    Given User has completed checkout
    When User clicks Back Home button
    Then User should be redirected to Products page
