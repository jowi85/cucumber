Feature: Login
  As a user I want to ensure the Giphy login page only allows access for valid user names and passwords.

  Scenario: Valid username and valid password
    Given Geckodriver executable configured
      And I am on Giphy login page
    When I enter Giphy credentials "<string>" and password "<string>"
    Then Successful Giphy login

  Scenario: Valid username and invalid password
    Given Geckodriver executable configured
      And I am on Giphy login page
    When I enter Giphy credentials "<string>" and password "<string>"
    Then Unsuccessful Giphy login