@SmokeTest
Feature: Sorting according to term

  @termLowToHigh1 @dev, @wip
  Scenario: login function
    Given user navigates to squirrel bank
    When user clicks the login link
    Then user should navigate to login page

  @termLowToHigh2 @dev, @wip
  Scenario: verify login
    Given user should be on login page
    When user enter below valid login details
      | username                  | password  |
      | robert+community@test.com | cls123456 |
    And user should click Login button
    Then user should successfully login

@termLowToHigh3 @dev, @wip
  Scenario: verify Duration of the Term Low to High
    Given user clicks on sorting dropdown
    When user selects duration of the term from low to high
    Then user should see the cards displayed as per the duration of the term in ascending order

@termLowToHigh4 @dev, @wip
  Scenario: verify Duration of the Term High to Low
    Given user clicks on sorting dropdown
    When user selects duration of the term from high to low
    Then user should see the cards displayed as per the duration of the term in descending order

    