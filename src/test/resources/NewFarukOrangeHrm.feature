@smokeTest @regressionTest @jenkinsTest
Feature: verify login feature in Orange HRM website 
Scenario: user able to successfully login to Orange HRM site 
	Given user go to Orang HRM home page 
	When user enter valid username and password 
	And user click on login button 
	Then uesr Navigate to welcome page 
	And user verify the page title as "OrangeHRM" 
	And user verify user name is displayes at top right 
	Then User log out 
	And user close browser