Feature: Login

Scenario: successful login with valid credential

Given user launch Chrome browser
When user opens url "https://www.facebook.com/login" 
And user enters email as "shubhamcoolkarni8196@gmail.com" and Password as "Shubham@8196"
And user click on Login
Then page title should be "(2) Facebook"
When user click on logout
Then page title should be "https://www.facebook.com/login"
And close browse

Scenario Outline: Login Data Driven

Given user launch Chrome browser
When user opens url "https://www.facebook.com/login" 
And user enters email as "<eamil>" and Password as "<password>"
Then page title should be "(2) Facebook"
When user click on logout
Then page title should be "https://www.facebook.com/login"
And close browse

   Examples:
          
          | email | password |
          | shubham8@gmail.com | shuh8pkp |
          | sgsgewam8@gmail.com | hhhpkp |
          | nhgham8@gmail.com | 248pkp |