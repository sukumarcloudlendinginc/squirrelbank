@SmokeTest
Feature: Place bid Invalid

@placeBidInvalid1 @dev, @wip
Scenario: login function
    Given user navigates to squirrel bank
    When user clicks the login link
    Then user should navigate to login page

@placeBidInvalid2 @dev, @wip    
Scenario: verify login
    Given user should be on login page
    When user enter below valid login details
      | username                  | password  |
      | robert+community@test.com | cls123456 |
    And user should click Login button
    Then user should successfully login
    
    
@placeBidInvalid3 @dev, @wip
Scenario: place bid
  Given user should be in investor home page
    When user clicks on first card
    Then user should navigate to detailed card view
    And Then user should click on volgende
    When user click volgende in bid page
    Then user should validate error message
    When user enter below invalid bid amounts
    | bidAmount |
    | 222222    |
    When user click volgende again in bid page
    Then user should validate error message after invalid input
    