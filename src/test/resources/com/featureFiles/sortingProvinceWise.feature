@SmokeTest
Feature: Sorting according to province

  @province1 @dev, @wip
  Scenario: login function
    Given user navigates to squirrel bank
    When user clicks the login link
    Then user should navigate to login page

  @province2 @dev, @wip
  Scenario: verify login
    Given user should be on login page
    When user enter below valid login details
      | username                  | password  |
      | robert+community@test.com | cls123456 |
    And user should click Login button
    Then user should successfully login

@province3 @dev, @wip
  Scenario: verify province in alphabetical ascending order
    Given user should click dropdown
    When user selects province A to Z
    Then user should see the cards displayed as per the province in alphabetical ascending order

@province4 @dev, @wip
  Scenario: verify province in alphabetical descending order
    Given user clicks on dropdown option
    When user selects province Z to A
    Then user should see the cards displayed as per the province in alphabetical descending order

    