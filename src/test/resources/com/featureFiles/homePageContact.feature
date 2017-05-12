@homePageContact @SmokeTest
Feature: verify homePageContact
	
@contactPage1 @SmokeTest @dev, @wip
Scenario: verify home page contact
Given user navigates to homePage
When user clicks contact link in the home page
Then user should be navigated to contact page


@contactPage2 @dev, @wip
Scenario: verify contact page objects
Given user should be in contact page
When user clicks expand and collapse icons for the frequently asked questions
Then validate the content of the all questions
And user should be navigated back to home page
Then close the driver


