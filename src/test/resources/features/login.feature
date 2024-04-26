Feature: Login

  Background:
    Given I open the main page
    And I accept cookies

    Scenario: User supplies incorrect credentials
      Given I am on the sign-in page
      When I enter 'username' and 'password'
      Then Login was successful or error message was shown



