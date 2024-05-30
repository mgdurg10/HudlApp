
Feature: To verify Login functionality for Hudl 
 
 Scenario: Verify login functionality with valid credentials
    Given user hits url
    Then user enters credentials
    Then validate loggedinName
  	

 Scenario: To verify Login functionality for Hudl with Invalid Credentials
    Given user hits url again
    Then user enters invalid username
    Then validate error
    
    
 Scenario: To verify Login functionality for Hudl with Invalid password
    Given user hits url again for password
    Then user enters invalid password
    Then validate error for password
    
