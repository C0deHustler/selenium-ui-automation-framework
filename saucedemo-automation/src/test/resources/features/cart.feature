Feature: Cart functionality on SauceDemo

  @Smoke @Cart
  Scenario: TC15 - Verify items in cart
    Given User is logged in with "standard_user" and "secret_sauce"
    When User adds 0 product to cart
    And User adds 1 product to cart
    And User navigates to Cart
    Then Cart should contain 2 items

  @Cart
  Scenario: TC16 - Remove item from cart
    Given User is logged in with "standard_user" and "secret_sauce"
    When User adds 0 product to cart
    And User navigates to Cart
    And User removes product from cart
    Then Cart should contain 0 items

  @Cart
  Scenario: TC17 - Proceed to checkout
    Given User is logged in with "standard_user" and "secret_sauce"
    When User adds 0 product to cart
    And User navigates to Cart
    And User proceeds to Checkout
    Then User should be redirected to Checkout Your Information page

  @Cart
  Scenario: TC18 - Continue shopping
    Given User is logged in with "standard_user" and "secret_sauce"
    When User adds 0 product to cart
    And User navigates to Cart
    And User clicks Continue Shopping button
    Then User should be redirected to Products page
