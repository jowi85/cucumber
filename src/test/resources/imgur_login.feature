Feature: Login
  As a user I want to ensure the Imgur login page only allows access for valid user names and passwords.

  Scenario: Valid username and valid password
    Given Geckodriver executable configured
      And I am on Imgur login page
    When I enter Imgur credentials "<string>" and password "<string>"
    Then Successful Imgur login

  Scenario: Valid username and invalid password
    Given Geckodriver executable configured
      And I am on Imgur login page
    When I enter Imgur credentials "<string>" and password "<string>"
    Then Unsuccessful Imgur login