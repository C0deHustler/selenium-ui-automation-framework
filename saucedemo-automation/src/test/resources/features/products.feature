Feature: Product Browsing and Selection on SauceDemo

  @Smoke @Products
  Scenario: TC07 - Verify default sorting option
    Given User is logged in with "standard_user" and "secret_sauce"
    Then Default sorting option should be "Name (A to Z)"

  @Products
  Scenario: TC08 - Sort products by Price (low to high)
    Given User is logged in with "standard_user" and "secret_sauce"
    When User applies filter "Price (low to high)"
    Then Products should be displayed in ascending order of price

  @Products
  Scenario: TC09 - Sort products by Price (high to low)
    Given User is logged in with "standard_user" and "secret_sauce"
    When User applies filter "Price (high to low)"
    Then Products should be displayed in descending order of price

  @Products
  Scenario: TC10 - Sort products by Name (Z to A)
    Given User is logged in with "standard_user" and "secret_sauce"
    When User applies filter "Name (Z to A)"
    Then Products should be displayed in reverse alphabetical order

  @Products
  Scenario: TC11 - Add single product to cart
    Given User is logged in with "standard_user" and "secret_sauce"
    When User adds 0 product to cart
    Then Cart should contain 1 items

  @Products
  Scenario: TC12 - Add multiple products to cart
    Given User is logged in with "standard_user" and "secret_sauce"
    When User adds 0 product to cart
    And User adds 1 product to cart
    Then Cart should contain 2 items

  @Products
  Scenario: TC13 - Remove product from cart
    Given User is logged in with "standard_user" and "secret_sauce"
    When User adds 0 product to cart
    And User navigates to Cart
    And User removes product from cart
    Then Cart should contain 0 items

  @Products
  Scenario: TC14 - Navigate to cart
    Given User is logged in with "standard_user" and "secret_sauce"
    When User navigates to Cart
    Then User should be redirected to Your Cart page
