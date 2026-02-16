Feature: Login functionality on SauceDemo

  @Smoke @Login
  Scenario: TC01 - Login with valid credentials
    Given User is on Login Page
    When User enters username "standard_user" and password "secret_sauce"
    And clicks on Login button
    Then User should be redirected to Products page

 @Login
  Scenario: TC02 - Login with invalid username
    Given User is on Login Page
    When User enters username "wrong_user" and password "secret_sauce"
    And clicks on Login button
    Then Error message "Username and password do not match" should be displayed

  @Login
  Scenario: TC03 - Login with invalid password
    Given User is on Login Page
    When User enters username "standard_user" and password "wrong_pass"
    And clicks on Login button
    Then Error message "Username and password do not match" should be displayed

  @Login
  Scenario: TC04 - Login with blank username and password
    Given User is on Login Page
    When User leaves username and password blank
    And clicks on Login button
    Then Error message "Username is required" should be displayed

  @Login
  Scenario: TC05 - Login with blank password
    Given User is on Login Page
    When User enters username "standard_user" and leaves password blank
    And clicks on Login button
    Then Error message "Password is required" should be displayed

  @Login
  Scenario: TC06 - Login with locked out user
    Given User is on Login Page
    When User enters username "locked_out_user" and password "secret_sauce"
    And clicks on Login button
    Then Error message "Sorry, this user has been locked out." should be displayed