@SmokeTest
Feature: Place bid

@placeBid1 @dev, @wip
Scenario: login function
    Given user navigates to squirrel bank
    When user clicks the login link
    Then user should navigate to login page

@placeBid2 @dev, @wip    
Scenario: verify login
    Given user should be on login page
    When user enter below valid login details
      | username                  | password  |
      | robert+community@test.com | cls123456 |
    And user should click Login button
    Then user should successfully login
    
    
@placeBid3 @dev, @wip
Scenario: place bid
  Given user should be in investor page
    When user clicks on first card
    Then user should navigate to detailed card view
    And Then user should click on volgende
    And Then user should place bid in the text field
    And Then user should click volgende
    And Then user should click checkbox for confirmation
    And Then user should click verzenden
    And Then user should redirect back to investor page
