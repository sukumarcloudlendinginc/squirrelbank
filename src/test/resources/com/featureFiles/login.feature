@login @SmokeTest
Feature: Verify login funtionality

  @login1  @dev, @wip
  Scenario: verify login funtionality with valid data
    Given user navigates to squirrel bank
    When user clicks the login link
    Then user should navigate to login page

  @login2 @dev, @wip
  Scenario: verify login form
    Given user should be on login page
    When user enter below valid login details
      | username                  | password  |
      | robert+community@test.com | cls123456 |
    And user should click Login button
    Then user should successfully login

